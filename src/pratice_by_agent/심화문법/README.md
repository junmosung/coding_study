# Agent Kotlin 심화 문법 문제 기획서

**기본문법(A01~A36) 다음 트랙**입니다. 이미 익힌 문법 위에, 실전에서 자주 쓰는 **표준 관용구 · 타입 시스템 심화 · DSL · JVM 동시성 API**를 붙입니다.

테마는 기본문법과 이어 **드론 물류 관제탑(Control Tower)** 입니다. 배송·재고·스케줄·백그라운드 작업을 “관제”하는 코드를 조금씩 완성합니다.

## 왜 이 트랙인가

기본문법에서 다룬 것 / 아직 얕은 것:

| 이미 다룸 | 심화에서 보강 |
|---|---|
| `try` 없이 null로 실패 모델링 | `Result`, `runCatching`, `require`/`check` |
| `Box<T>` 수준 제네릭 | `in`/`out`, `reified`, `inline` |
| `by lazy` | 인터페이스 위임, 커스텀 property delegate |
| 확장 함수 | `infix`, `operator`, DSL receiver |
| `Thread` + `synchronized` | `ExecutorService`, `Future`, `Atomic*`, `ConcurrentHashMap` |
| `filter`/`map`/`groupBy` | `fold`/`scan`/`zip`/`windowed`/`buildList` |

의존성 없이 **Kotlin stdlib + JVM**만 사용합니다. (Coroutine은 별도 트랙 후보)

## 난이도 구성

| 단계 | 문제 | 목표 | 완료 기준 |
|---|---:|---|---|
| 기본 | B01~B08 | 실패 처리, 검증, 문자열·컬렉션 빌더, 집계 | 예외를 던질지 `Result`로 감쌀지 선택할 수 있음 |
| 중급 | B09~B16 | inline/reified, 변성, value class, 위임 | 제네릭 선언의 의미를 말로 설명 |
| 고급 | B17~B22 | 연산자, infix, DSL, sealed interface | 짧은 DSL을 직접 설계·구현 |
| 최고급 | B23~B28 | Executor/Future, Atomic, 동시성 Map, 종합 | 블로킹 스레드 풀과 공유 상태를 안전하게 다룸 |

## 진행 규칙

1. 기본문법 A36까지 끝난 뒤 `B01`부터 순서대로 풉니다.
2. 10분 직접 시도 → 막히면 `B01 힌트만 줘`.
3. 풀이 후 `B01 채점해줘. 정답 코드는 바로 보여주지 마`.
4. 동시성 문제는 여러 번 실행해 레이스가 없는지 확인합니다.

## 문제별 문법 캐치 가이드

| 문제 | 핵심 문법 | 반드시 캐치할 점 |
|---|---|---|
| [B01 배송 검증](./A_기본/B01ValidateShipment.kt) | `require`, `check`, `error` | 사전조건/불변조건 실패는 예외로 빠르게 드러낸다 |
| [B02 안전 파싱](./A_기본/B02ParseScore.kt) | `runCatching`, `Result` | 예외를 값으로 바꿔 호출부에 전파 방식을 고른다 |
| [B03 결과 접기](./A_기본/B03FormatScore.kt) | `fold`, `getOrElse`, `map`/`mapCatching` | 성공/실패 분기 없이 변환 체인을 잇는다 |
| [B04 로그 빌더](./A_기본/B04BuildLog.kt) | `buildString` | 문자열 누적보다 빌더 스코프가 읽기 쉽다 |
| [B05 목록 빌더](./A_기본/B05RouteTable.kt) | `buildList`, `buildMap` | 내부는 mutable, 외부는 읽기 전용으로 공개 |
| [B06 구간 통계](./A_기본/B06WindowAverage.kt) | `windowed`, `chunked` | 슬라이딩/고정 분할의 차이를 안다 |
| [B07 경로 합치기](./A_기본/B07MoveDeltas.kt) | `zip`, `zipWithNext` | 두 시퀀스를 쌍으로 묶는 패턴 |
| [B08 누적 점수](./A_기본/B08BatteryFold.kt) | `fold`, `runningFold`/`scan` | 누적값의 중간 과정이 필요할 때를 구분 |
| [B09 인라인 측정](./B_중급/B09MeasureMs.kt) | `inline` 고차함수 | 람다 호출 비용을 줄이는 이유와 제약 |
| [B10 타입 재화](./B_중급/B10FilterIs.kt) | `reified` + `inline` | 런타임에 `T`를 보존하는 방법 |
| [B11 생산만](./B_중급/B11ReadWarehouse.kt) | `out` 변성 (공변) | `List<out T>`처럼 읽기 전용 생산자 |
| [B12 소비만](./B_중급/B12WriteLoader.kt) | `in` 변성 (반공변) | 쓰기 전용 소비자와 할당 규칙 |
| [B13 슬롯 ID](./B_중급/B13SlotId.kt) | `@JvmInline value class` | 타입은 구분하되 런타임 오버헤드를 줄인다 |
| [B14 엔진 위임](./B_중급/B14EngineDelegate.kt) | `class X : I by y` | 인터페이스 구현을 다른 객체에 맡긴다 |
| [B15 관측 위임](./B_중급/B15ObservableBattery.kt) | `ReadWriteProperty` / observable 패턴 | 프로퍼티 get/set을 가로챈다 |
| [B16 별칭 타입](./B_중급/B16TypeAliasRouter.kt) | `typealias` | 긴 함수 타입·중첩 타입에 이름을 붙인다 |
| [B17 좌표 연산](./C_고급/B17PointOps.kt) | `operator` (`plus`, `times`) | 도메인 타입에 산술 의미를 부여 |
| [B18 단위 infix](./C_고급/B18CargoInfix.kt) | `infix` | DSL처럼 읽히는 이항 호출 |
| [B19 관제 DSL](./C_고급/B19TowerDsl.kt) | 람다 with receiver | `Tower { }` 형태의 설정 DSL |
| [B20 경로 DSL](./C_고급/B20RouteInvoke.kt) | `invoke` 관례 | 객체를 함수처럼 호출 |
| [B21 사건 모델](./C_고급/B21TowerEvent.kt) | `sealed interface` | 계층을 interface로 열어 확장 지점을 조절 |
| [B22 비교 규칙](./C_고급/B22TicketComparable.kt) | `Comparable`, `compareBy` | 정렬 계약을 타입에 심는다 |
| [B23 스레드 풀](./D_최고급/B23ThreadPool.kt) | `ExecutorService`, `submit` | Thread를 직접 만들지 않고 풀에 맡긴다 |
| [B24 미래 값](./D_최고급/B24FutureCollect.kt) | `Future.get`, 타임아웃 | 비동기 결과 회수와 차단 지점 |
| [B25 원자 카운터](./D_최고급/B25AtomicCounter.kt) | `AtomicInteger` | 락 없이 단일 값을 안전하게 갱신 |
| [B26 동시성 맵](./D_최고급/B26ConcurrentStock.kt) | `ConcurrentHashMap` | 공유 Map의 기본 선택 |
| [B27 병렬 집계](./D_최고급/B27ParallelSum.kt) | 풀 + 분할 합치기 | map-reduce 감각의 병렬 합 |
| [B28 관제 파이프라인](./D_최고급/B28TowerPipeline.kt) | 종합 | Result·컬렉션·동시성을 한 흐름으로 조합 |

---

## 1단계 — 표준 관용구 (기본) B01~B08

### B01. 배송 검증
- 문법: `require`, `check`, `IllegalArgumentException`
- `validateShipment(weightKg, locked)`
  - `weightKg > 0` 아니면 `require` 실패
  - `locked == true` 아니면 `check` 실패
  - 성공 시 `"OK"`
- 예외 메시지에 실패한 조건을 포함

### B02. 안전 파싱
- 문법: `runCatching`, `Result`
- `parseScore(raw: String): Result<Int>`
  - Int 변환 실패 또는 `0..100` 밖이면 failure
- 성공/실패를 `Result`로만 표현 (`null` 반환 금지)

### B03. 결과 변환
- 문법: `Result.map`, `getOrElse`, `fold`
- `formatScore(raw)` → 성공 시 `"SCORE:n"`, 실패 시 `"SCORE:NA"`
- B02의 `parseScore`를 재사용

### B04. 로그 빌더
- 문법: `buildString`
- 이벤트 목록을 `"1) ...\n2) ..."` 형식 문자열로 조립
- 빈 목록이면 `"(empty)"`

### B05. 경로 테이블 빌더
- 문법: `buildList`, `buildMap`
- 정류장 이름 목록 → `List<"STOP-i:name">` 와 `Map<name, index>`를 함께 반환 (`Pair`)

### B06. 구간 평균
- 문법: `windowed`
- 센서값 리스트에서 크기 `size` 윈도우의 평균 리스트 반환
- `size`가 길이보다 크면 빈 리스트

### B07. 구간 이동량
- 문법: `zipWithNext`
- 연속 좌표(Int) 사이 차분 절대값 리스트 반환
- 예: `[1,4,2] → [3,2]`

### B08. 누적 배터리
- 문법: `fold` / `runningFold`
- 초기 배터리와 소모량 리스트로 **매 단계 잔량** 리스트를 반환 (음수면 0으로 클램프)
- 최종값만 필요한 버전(`fold`)과 중간값 버전을 모두 작성

---

## 2단계 — 타입 시스템 심화 (중급) B09~B16

### B09. 인라인 타이머
- 문법: `inline` 고차 함수
- `measureMs(block: () -> T): Pair<T, Long>`
  - 실행 결과와 경과 ms 반환
- `inline`으로 선언

### B10. 타입 재화 필터
- 문법: `inline` + `reified`
- `filterIs(list: List<Any>): List<T>`
  - `T` 타입만 남김 (`filterIsInstance`와 동등한 직접 구현)
- 호출 예: `filterIs<String>(listOf(1, "a", 2, "b"))`

### B11. 읽기 전용 창고
- 문법: 공변 `out`
- `Warehouse<out Cargo>`에서 꺼내기만 가능하도록 API 설계
- `BoxCargo`/`TubeCargo`를 넣고 `Warehouse<Cargo>`로 읽는 테스트

### B12. 쓰기 전용 적재함
- 문법: 반공변 `in`
- `Loader<in Cargo>`에 다양한 하위 타입을 넣을 수 있게 설계
- `Loader<Cargo>`에 `BoxCargo`를 적재하는 코드가 컴파일되는지 확인

### B13. 슬롯 ID 값 클래스
- 문법: `@JvmInline value class SlotId(val value: String)`
- 빈 문자열 생성 금지(`init`/`require`)
- `SlotId`와 일반 `String`이 서로 다른 타입임을 함수 시그니처로 강제

### B14. 엔진 인터페이스 위임
- 문법: `class Drone : Engine by engine`
- `Engine`의 `start()`/`stop()`을 위임으로 구현하고, `Drone`만의 `fly()`를 추가

### B15. 배터리 관측 위임
- 문법: 커스텀 property delegate (`ReadWriteProperty` 또는 간단한 `ObservableBattery`)
- `battery` 변경 시 콜백으로 이전값·새값을 통지
- 범위 `0..100` 밖 set은 무시 또는 예외 (정책 명시)

### B16. 핸들러 타입 별칭
- 문법: `typealias`
- `(Request) -> Response` 등 긴 함수 타입에 `Router`, `Middleware` 별칭을 붙이고 체인 함수 작성

---

## 3단계 — DSL과 연산자 (고급) B17~B22

### B17. 좌표 연산자
- 문법: `operator fun plus`, `times`
- `Point(x,y) + Point` / `Point * Int` 구현
- 예: `Point(1,2) + Point(3,4) == Point(4,6)`, `Point(2,3) * 2 == Point(4,6)`

### B18. 단위 infix
- 문법: `infix`
- `3.kg`, 또는 `5 at Zone.A`처럼 읽히는 API
- 예: `cargo("bolt") weighing 3` → `CargoSpec(name, kg)`

### B19. 관제탑 DSL
- 문법: 람다 with receiver (`TowerConfig.() -> Unit`)
- ```kotlin
  tower {
    name = "SEOUL"
    maxDrones = 8
    open()
  }
  ```
- 빌더가 `TowerConfig`를 반환

### B20. 라우트 invoke
- 문법: `operator fun invoke`
- `Route("A","B")(distanceKm = 12)` 처럼 호출해 `Leg`를 생성

### B21. 관제 사건
- 문법: `sealed interface`
- `TowerEvent` = `DroneOnline` / `DroneOffline` / `StockLow`
- `describe(event)`는 완전 `when` (else 금지)

### B22. 우선순위 비교
- 문법: `Comparable<T>`, `compareByDescending` + `thenBy`
- `Ticket(priority, id)` 자연 정렬: 우선순위 내림차순, 동점이면 id 오름차순
- `sorted()`만으로 원하는 순서가 나오게 구현

---

## 4단계 — JVM 동시성 실전 (최고급) B23~B28

### B23. 스레드 풀 실행
- 문법: `Executors.newFixedThreadPool`, `execute`/`submit`
- N개 작업을 풀에 넣고 모두 끝날 때까지 대기 (`shutdown` + `awaitTermination`)
- 직접 `Thread()` 생성 금지

### B24. Future 결과 수집
- 문법: `Future<T>`, `invokeAll` 또는 `submit` 목록
- 여러 파싱 작업을 병렬 제출 후 결과 `List`로 회수
- 실패한 Future는 정책에 따라 건너뛰거나 기본값

### B25. 원자적 요청 카운터
- 문법: `AtomicInteger`
- 멀티스레드 `incrementAndGet`으로 정확한 총합
- `synchronized` 사용 금지

### B26. 동시성 재고 맵
- 문법: `ConcurrentHashMap`
- `addStock`/`takeStock`이 스레드 안전하게 동작
- 재고 부족 시 `false` (예외 대신)

### B27. 병렬 구간 합산
- 문법: 풀 분할 + 부분 합 + 병합
- 큰 `List<Int>`를 청크로 나눠 병렬 합산 후 총합
- 단일 스레드 `sum()`과 결과 동일해야 함

### B28. 관제 종합 파이프라인
- 문법 종합: `Result` + 컬렉션 + `Executor` (선택) + 포맷
- 입력: `"드론:작업수"` 문자열 목록
- 규칙: 파싱 실패 제거 → 작업수 ≥ 3만 → 작업수↓·이름↑ 정렬 → `"#1 NAME (n jobs)"`
- 보너스: 파싱을 스레드 풀에서 병렬화해도 동일 결과

---

## 이후 트랙 후보 (아직 미착수)

| 후보 트랙 | 내용 | 비고 |
|---|---|---|
| 코루틴 | `suspend`, `async`/`await`, `Flow`, 구조적 동시성 | `kotlinx-coroutines` 의존성 추가 필요 |
| 코딩테스트 | 배열·투포인터·스택·그래프를 Kotlin으로 | 문법 적용 연습 |
| 실전 미니앱 | 콘솔 관제탑 CLI 한 덩어리 | A/B 트랙 타입 재사용 |

---

## 권장 반복 학습법

1. 먼저 `check` 통과 → 2. 불필요한 락/`!!`/수동 루프 제거 → 3. 타입·실패 정책을 설명 → 4. 테스트를 하나 추가해 변형.

시작 파일: [B01ValidateShipment.kt](./A_기본/B01ValidateShipment.kt)
