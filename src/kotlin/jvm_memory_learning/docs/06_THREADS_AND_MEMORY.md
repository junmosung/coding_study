# 06. 스레드별 Stack과 공유 Heap

각 JVM thread는 자신의 pc register와 JVM Stack을 갖지만 Heap은 모든 thread가 공유합니다. local variable 자체는 다른 thread가 직접 읽지 않더라도, local variable이 가리키는 객체를 다른 thread에도 전달하면 같은 Heap 상태를 함께 변경할 수 있습니다.

## local은 분리되고 객체는 공유될 수 있다

```kotlin
data class Counter(var value: Int)

val shared = Counter(0)

val workers = List(2) {
    Thread {
        val localRepeat = 100_000 // 각 thread frame의 local value
        repeat(localRepeat) {
            shared.value++        // 공유 Heap 객체의 field
        }
    }
}
workers.forEach(Thread::start)
workers.forEach(Thread::join)
```

두 thread의 `localRepeat`는 서로 다른 frame에 있지만 `shared`를 통해 같은 `Counter`에 도달합니다. `value++`는 읽기·증가·쓰기의 복합 연산이므로 결과가 유실될 수 있습니다.

## Java Memory Model이 답하는 것

Java Memory Model(JMM)은 실제 RAM 칸 배치도를 설명하지 않습니다. 여러 thread의 read가 어떤 write를 관찰할 수 있는지, compiler/JIT/CPU 재정렬 속에서도 어떤 실행이 허용되는지 정의합니다.

| 개념 | 의미 |
|---|---|
| atomicity | 연산이 중간 상태 없이 하나의 단위처럼 보이는가? |
| visibility | 한 thread의 write를 다른 thread가 보도록 보장하는가? |
| ordering | 연산 순서가 다른 thread에 어떤 제약으로 관찰되는가? |
| happens-before | 앞선 동작의 결과가 뒤 동작에 보인다는 가시성·순서 관계 |

## 대표적인 happens-before 관계

- 같은 thread 안에서 program order상 앞선 동작 → 뒤 동작
- monitor unlock → 이후 같은 monitor lock
- volatile write → 이후 같은 변수 volatile read
- `Thread.start()` 호출 전 동작 → 시작된 thread의 동작
- thread의 모든 동작 → 다른 thread에서 성공한 `join()` 이후 동작

그래서 worker가 결과를 쓴 뒤 main이 `join()`하면, main은 join 이후 그 결과를 볼 수 있는 동기화 관계를 얻습니다. 단, worker 여러 개가 같은 값을 경쟁적으로 갱신하는 복합 연산까지 자동으로 원자화되지는 않습니다.

## 도구별 보장

| 도구 | 적합한 문제 | 제공하지 않는 것 |
|---|---|---|
| `@Volatile` | 단일 flag의 visibility·순서 | `counter++` 같은 복합 연산 atomicity |
| `synchronized` | 임계 구역의 상호 배제와 visibility | 잘못된 lock 순서의 deadlock 방지 |
| `AtomicInteger` | CAS 기반 단일 값 원자 연산 | 여러 field를 묶은 복합 invariant |
| 불변 객체 | 변경 경쟁 제거 | 참조 교체 자체의 publication 보장 |
| message passing | 상태 소유권 분리 | queue 용량·실패·종료 정책 자동 결정 |

```kotlin
import java.util.concurrent.atomic.AtomicInteger

val counter = AtomicInteger(0)
val workers = List(2) {
    Thread { repeat(100_000) { counter.incrementAndGet() } }
}
workers.forEach(Thread::start)
workers.forEach(Thread::join)
check(counter.get() == 200_000)
```

## 안전한 publication

객체를 만든 thread와 사용하는 thread가 다르면 완전히 초기화된 상태가 안전하게 보이도록 전달 경로가 필요합니다. thread-safe queue, synchronization, volatile/atomic reference, thread start 이전 설정, immutable state와 적절한 publication을 사용합니다. 생성자에서 `this`를 listener나 global collection에 노출하는 코드는 초기화 도중 객체가 다른 thread에 보일 수 있어 피합니다.

## 코루틴에서도 같은 문제

코루틴이 `Dispatchers.Default` 같은 multi-thread dispatcher에서 실행되면 공유 Heap 상태에는 같은 JMM 문제가 적용됩니다. `Mutex`는 코루틴을 중단하는 상호 배제를 제공하지만, 일반 `synchronized`와 섞을 때는 어떤 도구가 어떤 상태를 보호하는지 일관된 규칙을 둡니다.

캐치 포인트: “변수가 Stack에 있으니 thread-safe”가 아니라, 그 변수에서 시작한 참조 그래프가 공유 Heap 객체에 닿는지를 확인합니다.

관련 문서: [JVM 스레드와 동시성 심화](../../docs/12_THREADS_CONCURRENCY.md), [코루틴 심화](../../docs/13_COROUTINES_ADVANCED.md)

공식 참고: [JLS §17.4 Memory Model](https://docs.oracle.com/javase/specs/jls/se21/html/jls-17.html#jls-17.4), [JLS §17.4.5 Happens-before](https://docs.oracle.com/javase/specs/jls/se21/html/jls-17.html#jls-17.4.5)
