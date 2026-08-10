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
for (i in 10 downTo 0 step 2) { } // 10, 8, 6, 4, 2, 0
```

`downTo`는 시작값부터 끝값까지 감소하는 범위를 만들며 기본적으로 양쪽 경계를 포함합니다.

```kotlin
for (i in 10 downTo 0) {
    println(i) // 10부터 0까지 출력
}
```

### downTo에서 미만·초과 표현하기

`downTo` 안에는 `<`, `>`를 직접 넣을 수 없습니다.

```kotlin
// 잘못된 문법
// for (i in 10 downTo > 0) { }
```

정수 경계가 단순하다면 제외할 경계를 한 칸 조정합니다.

```kotlin
val upper = 10
val lower = 0

// upper 미만, lower 초과: 9, 8, ..., 1
for (i in (upper - 1) downTo (lower + 1)) {
    println(i)
}

// upper 이하, lower 초과, 2씩 감소: 10, 8, 6, 4, 2
for (i in upper downTo (lower + 1) step 2) {
    println(i)
}
```

`step`은 첫 값부터 간격을 적용하므로 끝 경계가 범위에 포함되어 있어도 간격이 맞지 않으면 실제 순회 값에는 나타나지 않습니다.

```kotlin
for (i in 10 downTo 1 step 2) {
    println(i) // 10, 8, 6, 4, 2: 끝 경계 1은 간격이 맞지 않아 출력되지 않음
}
```

경계가 변수이고 “미만·초과인 동안”이라는 조건 자체가 중요한 경우에는 비교 연산자를 사용한 `while`이 더 명확합니다.

```kotlin
val upper = 10
val lower = 0
var current = upper - 1

while (current > lower) {
    println(current)
    current--
}
```

| 의도 | 권장 표현 |
|---|---|
| 양쪽 경계 포함 | `upper downTo lower` |
| 고정된 정수 경계 제외 | `(upper - 1) downTo (lower + 1)` |
| `<`, `>` 조건을 그대로 드러내기 | `while`과 비교 연산자 |
| 기존 범위에서 추가 조건 검사 | 반복문 내부의 `if` |

`Int.MIN_VALUE`와 `Int.MAX_VALUE` 부근에서 경계를 `-1`, `+1`로 조정하면 overflow가 발생할 수 있습니다. 외부 입력이나 극단적인 경계값을 다룬다면 `while` 조건을 사용하고 감소 전에 경계를 확인합니다.

캐치 포인트: `..`와 `downTo`는 경계를 포함하고 `until`과 `..<`는 마지막 경계를 포함하지 않습니다. 상태 변화가 필요 없다면 인덱스 반복보다 컬렉션 순회를 우선합니다.

공식 참고: [Basic syntax](https://kotlinlang.org/docs/basic-syntax.html), [Ranges and progressions](https://kotlinlang.org/docs/ranges.html)
