# Kotlin 기본 문법

## 변수와 타입 추론

```kotlin
val language = "Kotlin"  // 재할당 불가
var level = 1            // 재할당 가능
level += 1
```

- 기본값은 `val`입니다. 실제로 재할당이 필요할 때만 `var`를 사용합니다.
- 숫자 타입은 자동 확대 변환되지 않습니다. `Int`를 `Long`으로 바꾸려면 `toLong()`을 호출합니다.
- `==`는 값 비교, `===`는 참조 동일성 비교입니다.

## 표현식인 if와 when

```kotlin
val max = if (a > b) a else b

val grade = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    else -> "F"
}
```

Kotlin의 `if`, `when`, `try`는 값을 반환할 수 있습니다. 임시 변수를 변경하기보다 결과를 바로 대입하거나 반환합니다.

## 범위와 반복

```kotlin
for (i in 1..5) { }          // 1, 2, 3, 4, 5
for (i in 0 until 5) { }     // 0, 1, 2, 3, 4
for (i in 10 downTo 0 step 2) { }
```

캐치 포인트: `..`는 끝값을 포함하고 `until`은 포함하지 않습니다. 상태 변화가 필요 없다면 인덱스 반복보다 컬렉션 순회를 우선합니다.

공식 참고: [Basic syntax](https://kotlinlang.org/docs/basic-syntax.html)
