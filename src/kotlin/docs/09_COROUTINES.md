# 코루틴 기초

코루틴은 중단 가능한 계산입니다. `suspend`는 “새 스레드에서 실행”을 뜻하지 않으며, 함수가 중단 지점에서 멈췄다가 재개될 수 있음을 나타냅니다.

> `launch`, `async`, `delay`, `Flow`는 Kotlin 표준 라이브러리가 아니라 `kotlinx-coroutines` 의존성이 필요합니다.

```kotlin
suspend fun loadUser(): User {
    delay(100)
    return User("Kotlin")
}
```

## 핵심 구분

| 개념 | 의미 |
|---|---|
| `suspend` | 코루틴 문맥에서 중단 가능한 함수 |
| `CoroutineScope` | 코루틴 생명주기를 묶는 범위 |
| `launch` | 결과값이 없는 작업 시작, `Job` 반환 |
| `async` | 결과가 있는 작업 시작, `Deferred<T>` 반환 |
| `withContext` | 지정한 문맥에서 실행하고 결과 반환 |
| `Flow<T>` | 비동기적으로 여러 값을 방출하는 스트림 |

## 구조화된 동시성

```kotlin
suspend fun loadPage(): Page = coroutineScope {
    val user = async { loadUser() }
    val posts = async { loadPosts() }
    Page(user.await(), posts.await())
}
```

부모는 자식 완료를 기다리고, 취소와 실패는 계층을 통해 전파됩니다. 임의로 장수하는 전역 스코프를 만들기보다 소유자의 생명주기에 연결합니다.

## 스레드와의 관계

코루틴은 스레드와 1:1로 대응하지 않습니다. 여러 코루틴이 하나의 스레드를 나눠 쓸 수 있고, 하나의 코루틴이 중단 후 다른 스레드에서 재개될 수도 있습니다.

![코루틴이 메인 스레드와 IO worker 사이에서 중단·재개되는 흐름](./assets/coroutine-thread-handoff.svg)

- `delay(100)`은 코루틴을 중단하고 스레드를 다른 작업에 양보합니다.
- `Thread.sleep(100)`은 현재 스레드를 100ms 동안 점유합니다.
- `withContext(Dispatchers.IO)`는 블로킹 I/O를 Main 또는 CPU 작업용 스레드에서 분리할 때 사용합니다.
- 어떤 dispatcher에서도 공유 변경 상태에는 동기화 규칙이 필요합니다.

캐치 포인트: CPU 작업과 블로킹 I/O, 중단 가능한 I/O를 구분합니다. `suspend` 함수 안에서도 블로킹 호출은 스레드를 막습니다.

심화 학습: [JVM 스레드와 동시성](./12_THREADS_CONCURRENCY.md), [코루틴 심화](./13_COROUTINES_ADVANCED.md)

공식 참고: [Coroutines basics](https://kotlinlang.org/docs/coroutines-basics.html), [Coroutines guide](https://kotlinlang.org/docs/coroutines-guide.html)
