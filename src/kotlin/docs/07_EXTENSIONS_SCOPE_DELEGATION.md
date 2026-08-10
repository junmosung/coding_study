# 확장 함수, 스코프 함수, 위임

## 확장 함수

```kotlin
fun String.toSlug(): String = trim().lowercase().replace(" ", "-")
```

확장은 기존 클래스에 실제 멤버를 추가하지 않으며 정적으로 결정됩니다. 멤버 함수와 이름이 같으면 멤버 함수가 우선합니다.

## 스코프 함수 선택

| 함수 | 객체 참조 | 반환값 | 대표 용도 |
|---|---|---|---|
| `let` | `it` | 람다 결과 | nullable 변환 |
| `run` | `this` | 람다 결과 | 객체 문맥에서 계산 |
| `with` | `this` | 람다 결과 | 이미 있는 non-null 객체 작업 |
| `apply` | `this` | 객체 자신 | 객체 설정 |
| `also` | `it` | 객체 자신 | 로깅·부가 작업 |

```kotlin
val config = Config().apply {
    timeout = 1_000
}.also { logger.info("configured: $it") }
```

## 클래스와 프로퍼티 위임

```kotlin
class LoggingRepository(
    repository: Repository,
) : Repository by repository

val settings by lazy { loadSettings() }
```

클래스 위임 `by`는 구현 상속보다 합성을 간결하게 표현합니다. 프로퍼티 위임은 값 읽기·쓰기 정책을 재사용합니다.

캐치 포인트: 스코프 함수를 중첩해 수신 객체가 헷갈리면 일반 지역 변수로 되돌립니다.

공식 참고: [Extensions](https://kotlinlang.org/docs/extensions.html), [Scope functions](https://kotlinlang.org/docs/scope-functions.html), [Delegation](https://kotlinlang.org/docs/delegation.html)
