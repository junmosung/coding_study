# practice_by_agent — 중요 문법 ↔ 문제 맵

문제를 번호 순으로만 풀지 말고, **막힌 문법**을 이 표에서 찾아 해당 문제로 점프해도 됩니다.
이론 정리는 [`../docs`](../docs/README.md)를 참고합니다.

## 필수 문법 체크리스트

### 1) 기본 문법 트랙 (A01~A36)

| 중요도 | 문법 | 대표 문제 | 문서 |
|:---:|---|---|---|
| ★★★ | `val` / `if`·`when` 표현식 | A01, A04, A05 | [01](../docs/01_BASIC_SYNTAX.md) |
| ★★★ | 숫자 타입·명시적 변환 | A02 | [01](../docs/01_BASIC_SYNTAX.md) |
| ★★★ | nullable `?.` `?:` / `toIntOrNull` | A11, A12 | [02](../docs/02_NULL_SAFETY.md) |
| ★★★ | `filter` `map` `groupBy` 체인 | A13, A14, A17 | [05](../docs/05_COLLECTIONS_SEQUENCES.md) |
| ★★★ | `data class` + 빈 컬렉션 정책 | A15, A22 | [04](../docs/04_TYPE_MODELING.md) |
| ★★★ | `enum` / `sealed` / 완전 `when` | A23, A25 | [04](../docs/04_TYPE_MODELING.md) |
| ★★★ | 캡슐화 `private set` | A21 | [04](../docs/04_TYPE_MODELING.md) |
| ★★☆ | `interface` · 추상 클래스 | A24, A26 | [04](../docs/04_TYPE_MODELING.md) |
| ★★☆ | 제네릭 기초 · 확장 함수 | A27, A28 | [06](../docs/06_GENERICS_VARIANCE.md), [07](../docs/07_EXTENSIONS_SCOPE_DELEGATION.md) |
| ★★★ | 함수 타입 · 고차 함수 | A29 | [03](../docs/03_FUNCTIONS_LAMBDAS.md) |
| ★★☆ | 스코프 `apply`/`let` | A30 | [07](../docs/07_EXTENSIONS_SCOPE_DELEGATION.md) |
| ★★☆ | `by lazy` · `Sequence` | A31, A32 | [05](../docs/05_COLLECTIONS_SEQUENCES.md), [07](../docs/07_EXTENSIONS_SCOPE_DELEGATION.md) |
| ★★★ | `Thread` / `join` / `synchronized` | A33, A34, A35 | [10](../docs/10_JAVA_INTEROP.md) |
| ★★★ | 파싱→필터→정렬 파이프라인 | A36 | [05](../docs/05_COLLECTIONS_SEQUENCES.md), [11](../docs/11_IDIOMS_STYLE.md) |

### 2) 심화 문법 트랙 (B01~B28)

| 중요도 | 문법 | 대표 문제 | 문서 |
|:---:|---|---|---|
| ★★★ | `require` / `check` | B01 | [08](../docs/08_ERRORS_RESULT.md) |
| ★★★ | `Result` / `runCatching` | B02, B03 | [08](../docs/08_ERRORS_RESULT.md) |
| ★★☆ | `buildString` / `buildList` / `buildMap` | B04, B05 | [11](../docs/11_IDIOMS_STYLE.md) |
| ★★☆ | `windowed` / `zipWithNext` / `fold` | B06, B07, B08 | [05](../docs/05_COLLECTIONS_SEQUENCES.md) |
| ★★★ | `inline` + `reified` | B09, B10 | [06](../docs/06_GENERICS_VARIANCE.md) |
| ★★★ | 변성 `out` / `in` | B11, B12 | [06](../docs/06_GENERICS_VARIANCE.md) |
| ★★☆ | `value class` | B13 | [04](../docs/04_TYPE_MODELING.md) |
| ★★★ | 클래스·프로퍼티 위임 `by` | B14, B15 | [07](../docs/07_EXTENSIONS_SCOPE_DELEGATION.md) |
| ★★☆ | `typealias` | B16 | [03](../docs/03_FUNCTIONS_LAMBDAS.md) |
| ★★☆ | `operator` / `infix` / DSL receiver | B17~B20 | [03](../docs/03_FUNCTIONS_LAMBDAS.md), [07](../docs/07_EXTENSIONS_SCOPE_DELEGATION.md) |
| ★★☆ | `sealed interface` / `Comparable` | B21, B22 | [04](../docs/04_TYPE_MODELING.md) |
| ★★★ | `ExecutorService` / `Future` | B23, B24 | [10](../docs/10_JAVA_INTEROP.md) |
| ★★★ | `AtomicInteger` / `ConcurrentHashMap` | B25, B26 | [10](../docs/10_JAVA_INTEROP.md) |
| ★★☆ | 병렬 분할·병합 · 종합 파이프라인 | B27, B28 | [05](../docs/05_COLLECTIONS_SEQUENCES.md) |

## 학습 경로 (권장)

```text
docs/01~02 ──▶ 기본 A01~A12 ──▶ docs/05 ──▶ A13~A20
     │                              │
     └─ docs/04 ──▶ A21~A28 ──▶ docs/03·07 ──▶ A29~A36
                                              │
                         docs/08·06 ──▶ 심화 B01~B16
                                              │
                         docs/10 ──────▶ B23~B28 (동시성)
```

## 이 트랙에서 반드시 말로 설명할 것

1. `null` / 예외 / `Result`를 언제 고르는가?
2. `List` 체인과 `Sequence`의 실행 시점 차이는?
3. `enum` vs `sealed` vs `data class` 선택 기준은?
4. 공유 가변 상태를 `synchronized` / `Atomic*` / 동시성 컬렉션 중 무엇으로 보호하는가?

코루틴(`suspend`, `Flow`)은 docs/09에만 정리되어 있고, 이 연습 트랙 문제에는 넣지 않았습니다. (의존성 분리)
