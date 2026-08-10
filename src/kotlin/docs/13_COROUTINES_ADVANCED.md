# 코루틴 심화: 스레드, 취소, 실패 전파

코루틴은 스레드를 대체하는 또 하나의 스레드가 아니라, 실행을 중단하고 나중에 이어 갈 수 있는 작업 단위입니다. 코루틴의 생명주기는 `Job`이 관리하고 실제 실행 스레드는 `CoroutineDispatcher`가 결정합니다.

먼저 [코루틴 기초](./09_COROUTINES.md)에서 `suspend` / `runBlocking` / `delay` vs `Thread.sleep`을 익힌 뒤, [JVM 스레드와 동시성](./12_THREADS_CONCURRENCY.md)과 비교해 읽습니다.

## 코루틴과 스레드는 1:1이 아니다

![메인 스레드에서 시작한 코루틴이 IO worker로 이동해 중단 후 다른 worker에서 재개되고 메인으로 복귀하는 흐름](./assets/coroutine-thread-handoff.svg)

- 하나의 스레드는 여러 코루틴을 번갈아 실행할 수 있습니다.
- 하나의 코루틴은 디스패처나 중단 함수에 따라 다른 스레드에서 재개될 수 있습니다.
- `suspend`는 호출 스레드를 자동으로 바꾸지 않습니다.
- `delay`는 코루틴을 중단하지만 `Thread.sleep`은 현재 스레드를 블로킹합니다.

## Dispatcher 선택

| Dispatcher | 대표 용도 | 주의점 |
|---|---|---|
| 부모 문맥 상속 | 같은 실행 정책을 유지 | 기본 선택 |
| `Dispatchers.Default` | CPU 중심 계산 | 긴 블로킹 I/O 금지 |
| `Dispatchers.IO` | 파일·JDBC 등 블로킹 I/O | 무제한 병렬 실행으로 오해하지 않기 |
| `Dispatchers.Main` | UI 상태 접근 | Android, Swing 등 Main 구현 의존성 필요 |
| `limitedParallelism(n)` | 특정 작업군의 동시 실행 상한 | 전체 dispatcher를 새로 만드는 것은 아님 |

```kotlin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun loadReport(): Report {
    val raw = withContext(Dispatchers.IO) {
        blockingClient.fetchReport()
    }
    return withContext(Dispatchers.Default) {
        parseLargeReport(raw)
    }
}
```

호출자가 UI 문맥인지 서버 문맥인지 하위 함수가 가정하지 않게 하고, 블로킹 또는 CPU 작업을 실제로 수행하는 계층에서 필요한 dispatcher를 선택하는 방식이 재사용하기 좋습니다.

## 구조화된 동시성과 Job 트리

`coroutineScope` 안에서 만든 자식은 부모의 `Job`에 연결됩니다. 부모는 자식 완료를 기다리고, 일반적인 자식 실패는 부모와 형제를 취소합니다.

```text
request Job
├── user async
└── orders async   ← 실패
    └── 일반 coroutineScope에서는 user도 취소
```

```kotlin
suspend fun loadDashboard(): Dashboard = coroutineScope {
    val user = async { userApi.load() }
    val orders = async { orderApi.load() }
    Dashboard(user.await(), orders.await())
}
```

서로 독립적인 자식의 실패를 격리해야 할 때만 `supervisorScope`를 사용합니다. 격리했다고 실패가 처리된 것은 아니므로 각 자식의 오류를 관찰하고 정책에 따라 기록·대체·재시도해야 합니다.

```kotlin
suspend fun refreshWidgets(): List<WidgetResult> = supervisorScope {
    widgetIds.map { id ->
        async {
            runCatching { widgetApi.load(id) }
                .fold(
                    onSuccess = { WidgetResult.Loaded(id, it) },
                    onFailure = { WidgetResult.Failed(id, it) },
                )
        }
    }.awaitAll()
}
```

## 취소는 협력적이다

코루틴 취소는 `CancellationException`으로 전달됩니다. `delay`, `yield`, 채널 연산 같은 중단 함수는 취소를 확인하지만, 중단 지점이 없는 긴 계산은 직접 확인해야 합니다.

```kotlin
suspend fun calculate(items: List<Item>): ResultData {
    val result = ResultBuilder()
    for (item in items) {
        coroutineContext.ensureActive()
        result.add(expensiveTransform(item))
    }
    return result.build()
}
```

자원 해제는 `finally`에 둡니다. 중단 가능한 정리가 꼭 필요할 때만 짧은 `withContext(NonCancellable)`을 사용합니다.

```kotlin
val job = launch {
    val resource = acquire()
    try {
        resource.consume()
    } finally {
        resource.close()
    }
}
```

`catch (e: Exception)`으로 취소까지 삼키지 않습니다. 반드시 넓게 잡아야 한다면 `CancellationException`은 다시 던집니다.

```kotlin
try {
    remoteCall()
} catch (e: CancellationException) {
    throw e
} catch (e: IOException) {
    fallback()
}
```

## timeout과 재시도

`withTimeout`은 실패 시 `TimeoutCancellationException`을 던지고, `withTimeoutOrNull`은 `null`을 반환합니다. timeout은 하위 작업이 취소에 협력할 때 효과가 있습니다.

```kotlin
val response = withTimeoutOrNull(1_000) {
    service.fetch()
} ?: return CacheResult.Timeout
```

재시도는 다음을 명시해야 합니다.

- 재시도 가능한 실패인지
- 최대 횟수와 전체 시간 제한
- 지수 backoff와 jitter
- 작업이 중복 실행돼도 안전한지(idempotency)
- 호출자가 취소하면 즉시 멈추는지

## 공유 변경 상태

`Dispatchers.Default` 같은 다중 스레드 dispatcher에서 코루틴을 실행하면 스레드와 같은 경쟁 조건이 생깁니다. 코루틴이라는 이유만으로 `counter++`가 안전해지지 않습니다.

| 상황 | 도구 |
|---|---|
| 짧은 임계 구역에서 상태 변경 | `Mutex.withLock` |
| 이벤트를 한 소유자에게 전달 | `Channel` 또는 actor 형태 |
| 관찰 가능한 최신 상태 | `StateFlow`와 단일 갱신 책임 |
| 단일 원자 연산 | atomic 타입 |
| UI 상태 | Main 스레드 한정 |

```kotlin
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SafeCounter {
    private val mutex = Mutex()
    private var value = 0

    suspend fun increment(): Int = mutex.withLock {
        ++value
    }
}
```

`Mutex`의 잠금 대기는 스레드를 블로킹하지 않고 코루틴을 중단합니다. 임계 구역 안에서 오래 걸리는 I/O를 수행하면 다른 호출이 모두 기다리므로, 상태 검사·변경 범위만 짧게 보호합니다.

## launch와 async의 실패 관찰

| 빌더 | 반환 | 결과·실패 관찰 |
|---|---|---|
| `launch` | `Job` | 완료는 `join`, 실패는 부모/예외 처리 정책 |
| `async` | `Deferred<T>` | 값과 실패는 `await` |

결과가 필요하지 않는데 `async`를 사용하거나, `Deferred`를 만들고 `await`하지 않는 코드는 실패를 놓치기 쉽습니다. 병렬 실행이 목적이 아니라면 순차 호출이 더 단순할 수 있습니다.

## 운영 체크리스트

- `GlobalScope` 대신 소유자의 `CoroutineScope`를 사용했는가?
- 블로킹 호출이 `Default`나 Main 스레드를 점유하지 않는가?
- 모든 `async` 결과를 `await`하는가?
- timeout, 취소, 재시도 정책이 서로 충돌하지 않는가?
- 공유 상태에 단일 소유자나 동기화 규칙이 있는가?
- 로그에 요청 ID와 `CoroutineName` 등 추적 문맥이 보존되는가?
- 테스트에서 임의의 `Thread.sleep` 대신 coroutine test scheduler를 사용하는가?

캐치 포인트: 코루틴의 장점은 “스레드가 없다”가 아니라 작업의 생명주기, 취소, 실패 전파를 코드 구조 안에 표현할 수 있다는 점입니다.

공식 참고: [Coroutine context and dispatchers](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html), [Cancellation and timeouts](https://kotlinlang.org/docs/cancellation-and-timeouts.html), [Coroutine exceptions handling](https://kotlinlang.org/docs/exception-handling.html), [Shared mutable state](https://kotlinlang.org/docs/shared-mutable-state-and-concurrency.html)
