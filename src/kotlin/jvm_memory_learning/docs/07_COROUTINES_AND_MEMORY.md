# 07. 코루틴과 JVM 메모리 실전

> 언어 수준의 `suspend` / `runBlocking` / `delay` vs `Thread.sleep`은 먼저 [코루틴 기초](../../docs/09_COROUTINES.md)를 읽은 뒤 이 문서로 오세요.

코루틴은 JVM thread보다 가볍지만 메모리를 사용하지 않는 것은 아닙니다. 실행 중에는 dispatcher가 선택한 thread의 Stack에서 코드가 동작하고, 중단 후 다시 시작하는 데 필요한 상태는 compiler가 만든 continuation과 coroutine context, `Job` 같은 Heap 객체로 표현될 수 있습니다.

코루틴을 이해할 때는 다음 두 상태를 나누어 봅니다.

| 상태 | 주로 관찰할 곳 | 핵심 질문 |
|---|---|---|
| 실행 중 | 현재 thread의 JVM Stack | 호출이 얼마나 깊은가? blocking 중인가? |
| 중단·대기 중 | Heap의 continuation, `Job`, context와 캡처 객체 | 누가 이 coroutine과 local state를 계속 참조하는가? |

`suspend`는 “다른 thread에서 실행한다” 또는 “StackOverflow와 메모리 누수를 자동으로 막는다”는 뜻이 아닙니다. 실행을 중단하고 나중에 재개할 수 있다는 언어 수준의 약속입니다.

> 아래 예제의 `launch`, `delay`, `coroutineScope` 등은 `kotlinx-coroutines-core`가 필요합니다. 사용 중인 빌드 도구에 최신 호환 버전을 추가하세요. Kotlin 공식 문서의 2026년 예시는 `1.11.0`을 사용합니다.

```kotlin
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
}
```

## 1. 중단은 thread blocking과 다르다

```kotlin
import kotlinx.coroutines.delay

suspend fun loadProfile(id: Long): String {
    delay(100) // 기다리는 동안 현재 thread를 점유하지 않는다.
    return "user-$id"
}
```

`delay`에서 coroutine은 중단될 수 있고 thread는 다른 작업을 실행할 수 있습니다. 반면 `Thread.sleep(100)`은 호출한 thread를 그대로 점유합니다. 코루틴 안에서 blocking I/O를 호출하면 coroutine이 가벼워도 underlying thread는 막힙니다.

```kotlin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun readLegacyFile(): String = withContext(Dispatchers.IO) {
    legacyBlockingRead() // blocking API를 IO dispatcher 경계 안에 둔다.
}
```

`Dispatchers.IO`도 무한한 thread를 제공하지는 않습니다. blocking 작업의 수, timeout, 외부 시스템의 동시 처리 한도를 함께 제한해야 합니다.

## 2. suspend 재귀도 StackOverflowError가 날 수 있다

다음 함수는 `suspend`이지만 실제 중단 지점 없이 자기 자신을 계속 호출합니다.

```kotlin
suspend fun unsafeDepth(value: Int): Int {
    if (value == 0) return 0
    return 1 + unsafeDepth(value - 1)
}
```

호출 깊이가 충분히 커지면 현재 thread Stack에 frame이 계속 쌓여 `StackOverflowError`가 발생할 수 있습니다. `suspend` modifier는 일반 재귀를 반복문으로 변환하지 않습니다.

실제 데이터가 깊어질 수 있다면 명시적인 작업 목록을 사용합니다.

```kotlin
data class Node(val children: List<Node>)

fun countNodes(root: Node): Int {
    val pending = ArrayDeque<Node>()
    pending.addLast(root)
    var count = 0

    while (pending.isNotEmpty()) {
        val current = pending.removeLast()
        count++
        current.children.forEach(pending::addLast)
    }
    return count
}
```

이 코드는 호출 Stack 대신 Heap의 `ArrayDeque`에 남은 작업을 저장합니다. 따라서 StackOverflow를 피하지만, 입력이 지나치게 크면 queue 자체의 Heap 사용량은 별도로 관리해야 합니다. 오류를 없애는 것이 아니라 **어떤 메모리 영역에 어떤 상한을 둘지 선택하는 것**입니다.

## 3. 코루틴 메모리 누수는 보통 lifecycle 누수다

메모리 누수는 즉시 발생하는 특정 예외 이름이 아닙니다. 더는 필요 없는 객체가 살아 있는 `CoroutineScope`, `Job`, callback 또는 queue에서 계속 reachable한 상태입니다. 누수가 반복되면 GC 후에도 live set이 커지고 결국 `OutOfMemoryError: Java heap space`로 나타날 수 있습니다.

### 나쁜 예: 화면보다 오래 사는 coroutine

```kotlin
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class ReportScreen {
    private val imageCache = ByteArray(10 * 1024 * 1024)

    @OptIn(DelicateCoroutinesApi::class)
    fun startPolling() {
        GlobalScope.launch {
            while (isActive) {
                uploadHeartbeat(imageCache.size) // lambda가 ReportScreen 상태를 캡처
                delay(1_000)
            }
        }
    }
}
```

화면을 닫아도 `GlobalScope` coroutine은 애플리케이션 수명 동안 계속 실행될 수 있습니다. coroutine → lambda/continuation → `ReportScreen` → `imageCache` 참조 경로가 남으면 화면과 큰 배열을 GC가 회수할 수 없습니다.

### 수정: 소유 객체와 scope의 lifecycle을 맞춘다

```kotlin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class ReportPresenter : AutoCloseable {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val imageCache = ByteArray(10 * 1024 * 1024)

    private var pollingJob: Job? = null

    fun startPolling() {
        if (pollingJob?.isActive == true) return
        pollingJob = scope.launch {
            while (isActive) {
                uploadHeartbeat(imageCache.size)
                delay(1_000)
            }
        }
    }

    override fun close() {
        scope.cancel() // child coroutine을 취소하고 참조 graph를 끊을 기회를 만든다.
    }
}
```

프레임워크가 lifecycle scope를 제공한다면 직접 scope를 만들기보다 그것을 사용합니다. 예를 들어 Android의 `viewModelScope`와 `lifecycleScope`, server framework의 request/application scope처럼 종료 시점이 명확한 scope를 우선합니다.

## 4. 무제한 queue는 OOM으로 이어질 수 있다

생산 속도가 소비 속도보다 빠른데 buffer 상한이 없으면 대기 중인 메시지들이 Heap에 쌓입니다.

```kotlin
import kotlinx.coroutines.channels.Channel

data class Event(val payload: ByteArray)

// 위험: 소비가 느리면 Event와 ByteArray가 제한 없이 쌓일 수 있다.
val unsafeEvents = Channel<Event>(Channel.UNLIMITED)
```

실제 시스템에서는 용량과 overflow 정책을 명시합니다.

```kotlin
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel

val events = Channel<Event>(
    capacity = 100,
    onBufferOverflow = BufferOverflow.DROP_OLDEST,
)
```

`DROP_OLDEST`가 항상 정답은 아닙니다. 결제·주문 이벤트처럼 유실되면 안 되는 데이터는 producer를 중단시키는 backpressure, durable queue, 재시도 및 idempotency가 필요합니다. 핵심은 무제한 메모리를 장애 대응 전략으로 사용하지 않는 것입니다.

## 5. 취소되지 않는 CPU loop

coroutine cancellation은 협력적입니다. suspending function이나 cancellation 확인 없이 CPU loop만 실행하면 `cancel()` 뒤에도 계속 실행되면서 CPU와 캡처 객체를 붙잡을 수 있습니다.

```kotlin
// 나쁜 예: cancellation을 확인하지 않는다.
suspend fun hashForever(bytes: ByteArray) {
    while (true) {
        calculateHash(bytes)
    }
}
```

반복 작업 사이에 취소를 확인합니다.

```kotlin
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.yield

suspend fun hashUntilCancelled(bytes: ByteArray) {
    var rounds = 0
    while (true) {
        currentCoroutineContext().ensureActive()
        calculateHash(bytes)

        if (++rounds % 1_000 == 0) {
            yield() // 다른 coroutine에도 실행 기회를 준다.
        }
    }
}
```

너무 자주 확인하면 overhead가 생기고 너무 늦게 확인하면 취소 응답성이 나빠집니다. 실제 연산 시간을 측정해 batch 단위를 정합니다.

## 6. CancellationException을 삼키면 종료가 깨진다

`CancellationException`은 coroutine 취소를 전달하는 제어 흐름입니다. 모든 예외를 잡고 무시하면 취소된 작업이 계속 실행될 수 있습니다.

```kotlin
// 위험한 패턴
suspend fun retryForever() {
    while (true) {
        try {
            callRemoteApi()
        } catch (error: Exception) {
            log(error) // CancellationException까지 삼킬 수 있다.
        }
    }
}
```

취소는 다시 던지고, 재시도할 오류만 구분합니다.

```kotlin
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay

suspend fun retryWithCancellation() {
    while (true) {
        try {
            callRemoteApi()
            return
        } catch (cancelled: CancellationException) {
            throw cancelled
        } catch (error: RecoverableNetworkException) {
            log(error)
            delay(500) // 재시도 폭주를 막고 cancellation 지점도 제공한다.
        }
    }
}
```

## 7. 실제 사용: 요청 단위 병렬 조회

서로 독립적인 두 조회 결과가 모두 필요하면 request scope 안에서 `async`를 사용합니다. 부모 요청이 취소되면 자식도 함께 취소되고, 부모는 자식 완료를 기다립니다.

```kotlin
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withTimeout

data class Dashboard(val profile: Profile, val orders: List<Order>)

suspend fun loadDashboard(userId: Long): Dashboard = withTimeout(2_000) {
    coroutineScope {
        val profile = async { profileRepository.find(userId) }
        val orders = async { orderRepository.findRecent(userId) }
        Dashboard(profile.await(), orders.await())
    }
}
```

이 패턴의 경계는 명확합니다.

- 두 작업을 실제로 동시에 실행할 가치가 있을 때만 `async`를 사용합니다.
- repository가 blocking API라면 내부에서 적합한 dispatcher로 전환합니다.
- timeout은 무작정 짧게 두지 않고 외부 시스템 SLA와 재시도 정책에 맞춥니다.
- `Deferred`를 global collection에 계속 저장하지 않습니다. 완료 결과와 실패 객체가 collection을 통해 오래 유지될 수 있습니다.

## 8. 실제 사용: 자원은 finally에서 닫는다

취소도 예외이므로 socket, stream, dispatcher 같은 자원은 `finally` 또는 `use`로 정리합니다.

```kotlin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun copyRemoteFile(client: RemoteClient) = withContext(Dispatchers.IO) {
    client.openStream().use { input ->
        destination().use { output ->
            input.copyTo(output)
        }
    }
}
```

직접 만든 전용 dispatcher도 lifecycle이 있습니다.

```kotlin
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

Executors.newSingleThreadExecutor().asCoroutineDispatcher().use { dispatcher ->
    // dispatcher를 사용하는 제한된 작업
}
```

닫지 않은 executor나 `newSingleThreadContext`는 native thread와 Stack, OS 자원을 계속 유지할 수 있습니다.

## 9. 증상별 원인 지도

| 증상·오류 | 흔한 원인 | 먼저 확인할 것 |
|---|---|---|
| `StackOverflowError` | 깊은 재귀, `suspend` 재귀를 일반 반복으로 오해 | 반복문·명시적 queue 전환 가능성, 호출 깊이 |
| `OutOfMemoryError: Java heap space` | 취소되지 않은 장수 coroutine, 무제한 channel/cache, `Deferred` 결과 누적 | Heap dump의 dominator, GC 후 live set, collection 크기 |
| `unable to create native thread` 계열 OOM | executor·전용 dispatcher를 반복 생성하고 닫지 않음 | thread dump, dispatcher 생성 위치, close 여부 |
| 취소 후에도 CPU 100% | suspending/cancellation check 없는 loop | `ensureActive`, `yield`, batch 크기 |
| 화면·request 종료 후 작업 지속 | `GlobalScope`, 소유자보다 긴 custom scope | `Job` parent-child 관계, scope 취소 시점 |
| 응답 정지·thread 고갈 | request/UI thread에서 `runBlocking`, coroutine 안의 blocking I/O | thread dump, dispatcher, blocking call |
| 간헐적 값 손실 | 여러 coroutine이 shared mutable state 갱신 | `Mutex`, atomic, actor/state ownership |

## 10. 실제 진단 순서

1. 재현 시점의 Heap 사용량과 thread 수가 계속 증가하는지 확인합니다.
2. `-Dkotlinx.coroutines.debug`로 coroutine 이름을 thread 이름에 표시합니다.
3. IntelliJ Coroutine Debugger 또는 coroutine dump로 대기 중인 `Job`과 suspension 지점을 찾습니다.
4. Heap dump의 dominator tree에서 `Job`, continuation, `Channel`, 큰 collection과 `ByteArray`를 확인합니다.
5. GC root까지의 reference path를 따라가 어떤 scope·callback·static collection이 객체를 살리는지 찾습니다.
6. lifecycle 종료 후 active child 수, queue 크기, executor thread 수가 감소하는지 회귀 테스트합니다.

Heap dump 하나에서 객체가 많다는 이유만으로 누수라고 단정하지 않습니다. 같은 동작을 반복했을 때 GC 이후 live set과 retained object 수가 계속 증가하는지 비교해야 합니다.

## 체크리스트

- coroutine을 시작한 scope의 소유자와 종료 시점을 말할 수 있는가?
- `GlobalScope`가 정말 애플리케이션 전체 수명 작업인가?
- queue, channel, cache, 동시 요청 수에 상한이 있는가?
- CPU loop가 적절한 간격으로 cancellation을 확인하는가?
- `CancellationException`을 삼키지 않는가?
- blocking I/O가 request/UI/Default dispatcher를 막지 않는가?
- executor, stream, socket을 `use` 또는 `finally`로 닫는가?
- 깊이가 외부 입력에 비례하는 재귀를 반복 구조로 바꿀 수 있는가?

캐치 포인트: coroutine이 가볍다는 말은 thread 하나보다 생성 비용이 작다는 뜻이지, lifecycle·buffer·캡처 객체를 무제한으로 가져도 된다는 뜻이 아닙니다.

공식 참고: [Kotlin coroutine basics](https://kotlinlang.org/docs/coroutines-basics.html), [Coroutine context와 dispatcher](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html), [GlobalScope API와 resource leak 경고](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-global-scope/)

이전: [스레드와 Java Memory Model](./06_THREADS_AND_MEMORY.md)
