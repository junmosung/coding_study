# 타입 모델링

## 타입 선택표

| 타입 | 적합한 상황 |
|---|---|
| `data class` | 값 묶음, 구조적 동등성, `copy` 필요 |
| `enum class` | 고정된 단일 값 목록 |
| `sealed class/interface` | 서로 다른 데이터를 가진 제한된 경우의 수 |
| `value class` | 런타임 부담을 줄이며 원시 값을 도메인 타입으로 구분 |
| 일반 `class` | 생명주기와 변경 가능한 상태를 캡슐화 |

```kotlin
data class User(val id: UserId, val name: String)

@JvmInline
value class UserId(val value: String)

sealed interface LoadState {
    data object Loading : LoadState
    data class Success(val users: List<User>) : LoadState
    data class Failure(val reason: String) : LoadState
}
```

sealed 타입은 `when`에서 모든 경우를 처리했는지 컴파일러가 검사할 수 있습니다.

```kotlin
fun message(state: LoadState): String = when (state) {
    LoadState.Loading -> "loading"
    is LoadState.Success -> "${state.users.size} users"
    is LoadState.Failure -> state.reason
}
```

캐치 포인트: 문자열 상수로 상태를 표현하지 말고 가능한 상태와 데이터를 타입으로 묶습니다. `data class`의 `copy`는 깊은 복사를 보장하지 않습니다.

공식 참고: [Data classes](https://kotlinlang.org/docs/data-classes.html), [Sealed classes](https://kotlinlang.org/docs/sealed-classes.html)
