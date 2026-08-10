# Null 안전성

Kotlin은 `String`과 `String?`을 서로 다른 타입으로 취급합니다.

```kotlin
val name: String = "Kotlin"
val nickname: String? = null

val length = nickname?.length ?: 0
```

## 도구 선택

| 문법 | 의미 | 사용 시점 |
|---|---|---|
| `?.` | null이면 호출하지 않고 null 반환 | nullable 체인 |
| `?:` | null일 때 기본값 사용 | 최종 대체값 결정 |
| `as?` | 실패하면 null인 안전한 캐스트 | 외부 타입 검사 |
| `let` | null이 아닐 때만 변환 | 짧은 nullable 변환 |
| `takeIf` | 조건을 만족하면 자신, 아니면 null | 단일 값 필터링 |
| `!!` | null이면 예외 발생 | 원칙적으로 피함 |

```kotlin
fun parsePort(raw: String?): Int? = raw
    ?.toIntOrNull()
    ?.takeIf { it in 1..65_535 }
```

## 스마트 캐스트

```kotlin
fun printLength(value: String?) {
    if (value == null) return
    println(value.length) // String으로 스마트 캐스트
}
```

캐치 포인트: `null`, 빈 문자열, 빈 컬렉션은 서로 다른 상태입니다. 도메인에서 각각 어떤 의미인지 먼저 정합니다.

공식 참고: [Null safety](https://kotlinlang.org/docs/null-safety.html)
