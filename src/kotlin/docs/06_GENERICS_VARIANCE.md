# 제네릭과 변성

## 타입 파라미터와 제약

```kotlin
class Box<T>(val value: T)

fun <T : Comparable<T>> maxOfItems(a: T, b: T): T =
    if (a >= b) a else b
```

여러 제약은 `where`로 표현합니다.

```kotlin
fun <T> copy(item: T): T where T : CharSequence, T : Comparable<T> = item
```

## out: 생산자

```kotlin
interface Producer<out T> {
    fun produce(): T
}
```

`T`를 반환하기만 하는 타입은 공변 `out`으로 선언할 수 있습니다. `Producer<Dog>`를 `Producer<Animal>`로 사용할 수 있습니다.

## in: 소비자

```kotlin
interface Consumer<in T> {
    fun consume(value: T)
}
```

`T`를 받기만 하는 타입은 반공변 `in`으로 선언할 수 있습니다. `Consumer<Animal>`은 `Dog`도 받을 수 있습니다.

## 스타 프로젝션

`List<*>`는 원소 타입을 모르는 목록입니다. 안전하게 읽으면 `Any?`지만 구체 타입 값을 추가할 수 없습니다.

캐치 포인트: `in/out`을 외우기보다 해당 타입이 T를 생산하는지 소비하는지 표시합니다. 둘 다 수행하면 기본적으로 무공변입니다.

공식 참고: [Generics: in, out, where](https://kotlinlang.org/docs/generics.html)
