# 컬렉션과 Sequence

## 읽기 전용과 변경 가능 타입

```kotlin
val names: List<String> = listOf("Kim", "Lee")
val editable: MutableList<String> = names.toMutableList()
```

`List`는 읽기 전용 인터페이스입니다. 완전한 불변 객체를 항상 보장하는 것은 아니므로 변경 가능한 참조를 외부에 노출하지 않는 설계가 중요합니다.

## 변환 파이프라인

```kotlin
val result = users
    .filter { it.active }
    .sortedByDescending { it.score }
    .map { it.name }
```

자주 사용하는 사고 순서는 필터 → 정렬 → 변환 → 집계입니다. 실제 요구에 맞춰 불필요한 중간 연산을 줄입니다.

## List와 Sequence

```kotlin
val first = hugeList
    .asSequence()
    .filter { it.isValid() }
    .map { it.convert() }
    .firstOrNull()
```

| 선택 | 적합한 경우 |
|---|---|
| List 체인 | 데이터가 작고 연산이 단순하며 전체 결과가 필요함 |
| Sequence | 데이터가 크거나 연산 단계가 많고 일부 결과만 필요함 |

Sequence의 중간 연산은 지연되며 `toList`, `first`, `sum` 같은 종단 연산에서 실행됩니다. 작은 컬렉션에서는 Sequence 변환 비용이 오히려 불필요할 수 있습니다.

캐치 포인트: 체인 중간의 타입과 실행 횟수를 설명할 수 있어야 합니다. 함수 목록은 [컬렉션 치트시트](../KOTLIN_CHEATSHEET.md)를 참고합니다.

공식 참고: [Collections overview](https://kotlinlang.org/docs/collections-overview.html), [Sequences](https://kotlinlang.org/docs/sequences.html)
