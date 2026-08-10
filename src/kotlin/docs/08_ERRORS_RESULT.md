# 오류 처리와 Result

## 선택 기준

| 표현 | 적합한 상황 |
|---|---|
| nullable `T?` | 값이 없는 것이 예상 가능한 정상 상태이고 이유가 중요하지 않음 |
| 예외 | 정상 흐름을 계속할 수 없는 실패 |
| `Result<T>` | 성공과 실패를 호출자가 명시적으로 조합해야 함 |
| `require` | 호출자가 잘못된 인수를 전달함 |
| `check` | 객체나 프로그램의 현재 상태가 올바르지 않음 |

```kotlin
fun parseAge(raw: String): Result<Int> = runCatching {
    raw.toInt().also { require(it >= 0) }
}

val label = parseAge("20").fold(
    onSuccess = { "age=$it" },
    onFailure = { "invalid" },
)
```

## try도 표현식

```kotlin
val value = try {
    riskyCall()
} catch (e: IOException) {
    fallback()
} finally {
    resource.close()
}
```

리소스가 `Closeable` 또는 `AutoCloseable`이면 직접 `finally`를 작성하기보다 `use`를 우선합니다.

```kotlin
reader.use { it.readText() }
```

캐치 포인트: 모든 예외를 잡고 무시하지 않습니다. 복구할 수 있는 예외만 처리하고 나머지는 실패 원인을 보존합니다.

공식 참고: [Exceptions](https://kotlinlang.org/docs/exceptions.html), [Result API](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-result/)
