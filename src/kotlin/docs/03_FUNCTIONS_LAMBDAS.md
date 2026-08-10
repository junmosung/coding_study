# 함수와 람다

## 함수 선언

```kotlin
fun add(a: Int, b: Int): Int = a + b

fun connect(host: String, port: Int = 8080, secure: Boolean = true) = Unit

connect(host = "localhost", secure = false)
```

- 한 표현식이면 표현식 본문 `=`을 사용할 수 있습니다.
- 기본 인수와 이름 있는 인수는 오버로드 수를 줄이고 호출부 의미를 드러냅니다.
- 공개 API는 반환 타입을 명시하면 의도하지 않은 API 변경을 줄일 수 있습니다.

## 함수 타입과 람다

```kotlin
val double: (Int) -> Int = { value -> value * 2 }

fun transform(values: List<Int>, operation: (Int) -> Int): List<Int> =
    values.map(operation)
```

마지막 파라미터가 함수이면 람다를 괄호 밖으로 뺄 수 있습니다.

```kotlin
transform(listOf(1, 2, 3)) { it * 10 }
```

## inline과 reified

`inline`은 고차 함수 호출 비용과 비지역 반환에 영향을 줍니다. `reified` 타입 파라미터는 인라인 함수 안에서 `is T` 같은 런타임 타입 검사를 가능하게 합니다.

```kotlin
inline fun <reified T> Iterable<*>.onlyType(): List<T> = filterIsInstance<T>()
```

캐치 포인트: 짧다는 이유만으로 모든 함수를 표현식 본문이나 `inline`으로 만들지 않습니다. 호출부와 실패 정책이 읽히는지가 기준입니다.

공식 참고: [Functions](https://kotlinlang.org/docs/functions.html), [Inline functions](https://kotlinlang.org/docs/inline-functions.html)
