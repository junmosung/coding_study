# Kotlin 관용구와 스타일

## 기본 원칙

- 변경하지 않는 값은 `val`로 선언합니다.
- 외부에 변경 가능한 컬렉션을 노출하지 않습니다.
- `Unit` 반환 타입과 세미콜론은 특별한 이유가 없으면 생략합니다.
- 단순 변수 문자열 템플릿은 `$name`, 표현식은 `${users.size}`를 사용합니다.
- 함수는 하나의 책임과 명확한 실패 정책을 갖습니다.

## 명령형 코드 다듬기

```kotlin
// Before
val result = mutableListOf<String>()
for (user in users) {
    if (user.active) result.add(user.name)
}

// After
val result = users.filter { it.active }.map { it.name }
```

하지만 상태 변화와 조기 종료가 핵심이면 반복문이 더 명확할 수 있습니다.

## 이름과 파일 구성

- 클래스와 객체: `UpperCamelCase`
- 함수와 프로퍼티: `lowerCamelCase`
- 상수: `UPPER_SNAKE_CASE`
- 패키지: 소문자, 밑줄 없이 사용하는 것이 일반적
- 파일 이름: 대표 타입이나 역할과 일치

## 피해야 할 신호

- 설명 없이 사용하는 `!!`
- 여러 단계로 중첩된 `let`, `apply`, `also`
- 단순 문자열로 표현한 상태와 종류
- 반환 타입만 다른 모호한 함수 이름
- 작은 컬렉션에 습관적으로 붙인 `asSequence()`
- 모든 예외를 잡는 `catch (e: Exception)` 후 무시

캐치 포인트: Kotlin다운 코드는 가장 짧은 코드가 아니라 타입과 의도가 선명한 코드입니다.

공식 참고: [Coding conventions](https://kotlinlang.org/docs/coding-conventions.html), [Idioms](https://kotlinlang.org/docs/idioms.html)
