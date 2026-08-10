# 심화 문법 — B01~B28

기본 문법(A01~A36) 다음 트랙입니다. **관제탑** 시나리오로 표준 관용구·타입 시스템·DSL·JVM 동시성을 익힙니다.
의존성 없이 Kotlin stdlib + JVM만 사용합니다. (코루틴은 [`docs/09`](../../docs/09_COROUTINES.md) 참고, 문제는 별도)

진입 전: [`GRAMMAR_MAP.md`](../GRAMMAR_MAP.md) 심화 ★★★, [`docs/08`](../../docs/08_ERRORS_RESULT.md)·[`06`](../../docs/06_GENERICS_VARIANCE.md)·[`10`](../../docs/10_JAVA_INTEROP.md)

## 단계 목표

| 단계 | 문제 | 목표 | 완료 기준 |
|---|---:|---|---|
| [A · 기본](./A_기본/README.md) | B01~B08 | 검증·Result·빌더·집계 | 예외 vs `Result` 선택 이유 설명 |
| [B · 중급](./B_중급/README.md) | B09~B16 | inline/reified·변성·위임 | `in`/`out`/`reified`를 한 문장으로 설명 |
| [C · 고급](./C_고급/README.md) | B17~B22 | operator·infix·DSL | 호출부만 보고 API 의도 예측 |
| [D · 최고급](./D_최고급/README.md) | B23~B28 | Executor·Atomic·종합 | Thread 직접 생성 vs 풀/원자변수 구분 |

## A · 기본 — 실패 처리와 표준 빌더

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [B01 배송 검증](./A_기본/B01ValidateShipment.kt) | 잘못된 인수는 `require`, 상태 오류는 `check` | `require` / `check` 메시지 |
| [B02 안전 파싱](./A_기본/B02ParseScore.kt) | `0..100`만 성공, 그 외 `Result.failure` | `runCatching` / `Result` |
| [B03 결과 변환](./A_기본/B03FormatScore.kt) | 성공 `"SCORE:n"`, 실패 `"SCORE:NA"` | `map` / `getOrElse` / `fold` |
| [B04 로그 빌더](./A_기본/B04BuildLog.kt) | `"1) …\n2) …"`, 빈 목록 `"(empty)"` | `buildString` |
| [B05 경로 테이블](./A_기본/B05RouteTable.kt) | 라벨 리스트 + 이름→인덱스 Map | `buildList` / `buildMap` |
| [B06 구간 평균](./A_기본/B06WindowAverage.kt) | 슬라이딩 윈도우 평균 | `windowed` |
| [B07 이동량](./A_기본/B07MoveDeltas.kt) | 연속 좌표 차분 절대값 | `zipWithNext` |
| [B08 누적 배터리](./A_기본/B08BatteryFold.kt) | 최종값(`fold`) + 궤적(`runningFold`) | 누적 vs 중간 과정 |

## B · 중급 — 제네릭·위임

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [B09 인라인 타이머](./B_중급/B09MeasureMs.kt) | 실행 결과 + 경과 ms | `inline` 고차 함수 |
| [B10 타입 재화](./B_중급/B10FilterIs.kt) | `T`만 남김 (`filterIsInstance` 금지) | `reified` |
| [B11 읽기 창고](./B_중급/B11ReadWarehouse.kt) | `Warehouse<out T>`로 공변 읽기 | `out` |
| [B12 쓰기 적재함](./B_중급/B12WriteLoader.kt) | `Loader<in T>`로 반공변 쓰기 | `in` |
| [B13 슬롯 ID](./B_중급/B13SlotId.kt) | 빈 문자열 금지 식별자 타입 | `value class` |
| [B14 엔진 위임](./B_중급/B14EngineDelegate.kt) | `Engine by engine` + `fly()` | 클래스 위임 `by` |
| [B15 배터리 관측](./B_중급/B15ObservableBattery.kt) | 변경 통지, 범위 밖 set 무시 | `ReadWriteProperty` |
| [B16 라우터 별칭](./B_중급/B16TypeAliasRouter.kt) | `Router` 체인 `then` | `typealias` |

## C · 고급 — DSL·연산자

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [B17 좌표 연산](./C_고급/B17PointOps.kt) | `+`, `*` 연산자 | `operator` |
| [B18 단위 infix](./C_고급/B18CargoInfix.kt) | `cargo("bolt") weighing 3` | `infix` |
| [B19 관제 DSL](./C_고급/B19TowerDsl.kt) | `tower { name=…; open() }` | 람다 with receiver |
| [B20 라우트 invoke](./C_고급/B20RouteInvoke.kt) | `Route("A","B")(12)` | `invoke` |
| [B21 관제 사건](./C_고급/B21TowerEvent.kt) | Online/Offline/StockLow 문구 | `sealed interface` |
| [B22 티켓 정렬](./C_고급/B22TicketComparable.kt) | 우선순위↓, id↑ 자연 정렬 | `Comparable` |

## D · 최고급 — JVM 동시성

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [B23 스레드 풀](./D_최고급/B23ThreadPool.kt) | N 작업 제출 후 종료 대기 | `ExecutorService` (`Thread()` 금지) |
| [B24 Future 수집](./D_최고급/B24FutureCollect.kt) | 병렬 파싱, 실패 스킵 | `Future` / `submit` |
| [B25 원자 카운터](./D_최고급/B25AtomicCounter.kt) | 멀티스레드 정확한 합 | `AtomicInteger` (`synchronized` 금지) |
| [B26 동시성 재고](./D_최고급/B26ConcurrentStock.kt) | add/take 스레드 안전 | `ConcurrentHashMap` |
| [B27 병렬 합산](./D_최고급/B27ParallelSum.kt) | 청크 분할 합 == `sum()` | 분할·병합 |
| [B28 관제 파이프라인](./D_최고급/B28TowerPipeline.kt) | 파싱→≥3→정렬→`#n` | 종합 체인 |

## 습관

- 실패: 인수 → `require`, 상태 → `check`, 복구 가능 → `Result`
- 변성: 꺼내기만 하면 `out`, 넣기만 하면 `in`
- 동시성: 단일 카운터는 Atomic, 맵은 Concurrent*, 작업 묶음은 Executor

이전 트랙: [기본 문법](../기본문법/README.md)
