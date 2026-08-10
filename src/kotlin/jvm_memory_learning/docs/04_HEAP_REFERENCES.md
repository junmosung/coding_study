# 04. Heap, 객체와 참조

JVM 명세의 Heap은 모든 JVM 스레드가 공유하며 class instance와 array가 할당되는 영역입니다. 변수와 객체를 분리해서 생각하면 Kotlin의 `val`, equality, data class copy를 더 정확히 이해할 수 있습니다.

## val은 참조 고정이지 깊은 불변이 아니다

```kotlin
data class Cart(val items: MutableList<String>)

val cart = Cart(mutableListOf("book"))
cart.items += "pen"       // 가능: 같은 객체 내부 상태 변경
// cart = Cart(...)        // 불가: 변수 cart 재할당
```

개념적으로 local variable `cart`의 참조는 재할당할 수 없지만, 그 참조가 도달하는 `Cart`와 `MutableList` 객체의 변경 가능성은 각 타입의 API가 결정합니다.

## alias: 여러 참조가 같은 객체를 가리키기

```kotlin
data class Meter(var value: Int)

val first = Meter(10)
val second = first
second.value = 99

check(first.value == 99)
check(first === second)
```

`second = first`는 객체를 복제하지 않습니다. 참조 값을 복사하므로 두 변수가 같은 객체에 도달합니다. 이를 aliasing이라고 합니다.

## ==와 ===

| 연산 | 질문 | 일반적인 구현 |
|---|---|---|
| `a == b` | 두 값의 구조적 의미가 같은가? | null-safe `equals` 호출 |
| `a === b` | 두 참조가 동일한 instance를 가리키는가? | referential equality |

```kotlin
data class Point(val x: Int, val y: Int)

val a = Point(1, 2)
val b = Point(1, 2)

check(a == b)    // data class가 생성한 equals
check(a !== b)   // 서로 다른 instance
```

문자열이나 boxed number에 `===`를 사용해 caching 여부를 추측하지 않습니다. 의미 비교에는 `==`를 사용합니다.

## data class copy는 얕은 복사

```kotlin
data class Team(
    val name: String,
    val members: MutableList<String>,
)

val original = Team("A", mutableListOf("Kim"))
val copied = original.copy(name = "B")

copied.members += "Lee"
check(original.members == listOf("Kim", "Lee"))
check(original.members === copied.members)
```

`copy()`는 바깥 `Team` instance를 새로 만들지만 constructor argument로 전달되는 내부 참조를 재귀적으로 복사하지 않습니다. 깊은 불변이 필요하면 immutable element와 읽기 전용 API만으로는 충분한지, 외부 mutable reference가 남지 않는지까지 확인합니다.

## nullable도 참조 상태다

```kotlin
var selected: User? = loadUser()
selected = null
```

`selected = null`은 객체를 삭제하는 명령이 아닙니다. 해당 변수의 도달 경로 하나를 끊는 것입니다. 다른 field, collection, thread local 등이 같은 객체를 가리키면 객체는 계속 살아 있습니다.

## 배열과 collection

- JVM 명세에서 array는 Heap 객체입니다.
- `List<T>`는 읽기 전용 interface이지 객체의 깊은 불변성을 보장하지 않습니다.
- collection이 element reference를 보유하면 collection이 도달 가능한 동안 element도 대개 도달 가능합니다.
- `map`, `filter`, `toList`는 결과 collection이나 중간 객체를 만들 수 있지만 실제 allocation은 구현과 최적화에 따라 달라집니다.

캐치 포인트: 메모리 문제는 “변수 하나”보다 **참조 그래프**로 그려야 풀립니다.

공식 참고: [Kotlin equality](https://kotlinlang.org/docs/equality.html), [Kotlin data class copy](https://kotlinlang.org/docs/data-classes.html#copying), [JVMS Heap](https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-2.html#jvms-2.5.3)

다음: [객체 수명과 GC](./05_GC_AND_LIFETIME.md)
