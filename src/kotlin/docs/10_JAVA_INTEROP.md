# Java 상호 운용

Kotlin/JVM은 Java 코드를 자연스럽게 호출할 수 있지만 nullability와 함수 시그니처 차이를 주의해야 합니다.

## 플랫폼 타입

Java에서 넘어온 `String!` 같은 플랫폼 타입은 Kotlin 컴파일러가 null 여부를 확정하지 못한 타입입니다. 외부 경계에서 nullable 여부를 명시적으로 정리합니다.

```kotlin
val name: String? = javaUser.name
val safeName = name ?: "unknown"
```

## Java에 친화적인 Kotlin API

| 애노테이션 | 목적 |
|---|---|
| `@JvmStatic` | companion/object 함수를 Java static처럼 노출 |
| `@JvmField` | getter 없이 필드로 노출 |
| `@JvmOverloads` | 기본 인수 함수의 Java 오버로드 생성 |
| `@JvmName` | JVM 메서드 이름 충돌 또는 호출 이름 조정 |
| `@Throws` | Java 호출자에게 checked exception 선언 노출 |

```kotlin
class Client @JvmOverloads constructor(
    val host: String,
    val timeout: Int = 1_000,
)
```

## 컬렉션과 SAM

- Kotlin 읽기 전용 컬렉션과 Java 컬렉션 사이에서는 Java 코드가 실제 객체를 변경할 가능성을 고려합니다.
- Java의 단일 추상 메서드 인터페이스는 Kotlin 람다로 전달할 수 있습니다.
- Kotlin의 함수 타입을 Java 공개 API에 그대로 노출하면 호출 문법이 불편할 수 있으므로 `fun interface`를 고려합니다.

캐치 포인트: Java 경계에서는 플랫폼 타입, checked exception, 기본 인수, 프로퍼티 접근이 Kotlin 내부와 다르게 보입니다.

공식 참고: [Calling Java from Kotlin](https://kotlinlang.org/docs/java-interop.html), [Calling Kotlin from Java](https://kotlinlang.org/docs/java-to-kotlin-interop.html)
