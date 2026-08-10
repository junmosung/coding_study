# Agent Kotlin 기본 문법 문제 기획서

서로 단절된 예제 대신 **드론 물류 센터 운영 프로그램**을 조금씩 완성하며 Kotlin 문법을 익히는 문제 목록입니다.
각 함수는 예시 입출력을 만족하도록 작성하고, `check(...)`가 모두 통과하면 해당 문법 단계를 완료한 것으로 봅니다.

## 난이도 구성

| 단계 | 문제 | 목표 | 완료 기준 |
|---|---:|---|---|
| 기본 | A01~A10 | `val`/`var`, 타입, 함수, 조건, 범위, 반복 | 값·제어 흐름을 표현식 중심으로 설명할 수 있음 |
| 중급 | A11~A20 | null 안전성, 컬렉션, Map, 정렬, 구조 분해 | `!!` 없이 빈 값 정책을 세우고 컬렉션 체인을 읽을 수 있음 |
| 고급 | A21~A28 | 클래스, enum, sealed, 인터페이스, 제네릭, 확장 | 상태·경우의 수를 타입으로 모델링할 수 있음 |
| 최고급 | A29~A36 | 고차 함수, 스코프, Sequence, **메인/서브 스레드**, 동기화 | 함수 조합과 JVM 스레드 기본을 실전처럼 다룰 수 있음 |

난이도는 코드 길이가 아니라 **타입 설계와 언어 기능을 선택하는 판단의 복잡도**를 기준으로 나눴습니다.

## Codex 트랙과의 차이

| 항목 | `pratice_by_codex` | `pratice_by_agent` |
|---|---|---|
| 테마 | 우주 탐사대 | 드론 물류 센터 |
| 문제 수 | 30 (C01~C30) | 36 (A01~A36) |
| 최고급 확장 | 고차함수·스코프·파이프라인 | + `lazy`/`Sequence` + **Thread / synchronized / 작업 큐** |
| 패키지 | `pratice_by_codex` | `pratice_by_agent` |

## 진행 규칙

1. 문제 번호 순서대로 풉니다.
2. 먼저 표준 라이브러리 문서를 찾지 않고 10분간 직접 시도합니다.
3. 막히면 Agent에게 `A01 힌트만 줘`라고 요청합니다.
4. 풀이 뒤에는 `A01 채점해줘. 정답 코드는 바로 보여주지 마`라고 요청합니다.
5. 모든 예시뿐 아니라 빈 컬렉션, 경계값, `null`, 스레드 문제의 순서 비결정성도 직접 테스트합니다.

## Kotlin을 주 언어로 만들기 위한 기준

- 기본 선택은 `var`보다 `val`, 변경 가능 컬렉션보다 읽기 전용 컬렉션입니다.
- 값을 결정하는 로직은 문장형보다 `if`/`when`/표현식 본문을 활용합니다.
- `null`은 `!!`로 피하지 말고 `?.`, `?:`, `let`, `takeIf`로 처리합니다.
- 컬렉션은 “어떻게 반복할지”보다 `filter`/`map`/`groupBy`처럼 “무엇을 원하는지”가 읽히게 작성합니다.
- 데이터는 불변 `data class`로 모델링하고, 변경은 `copy`로 표현합니다.
- 경우의 수가 닫혀 있으면 `enum` 또는 `sealed class`로 컴파일러의 도움을 받습니다.
- 스코프 함수는 목적이 분명할 때만 사용합니다.
- **스레드:** UI/메인과 무거운 작업을 분리하고, 공유 상태는 `synchronized` 또는 동시성 컬렉션으로 보호합니다.

## 문제별 문법 캐치 가이드

| 문제 | 핵심 문법 | 반드시 캐치할 점 |
|---|---|---|
| [A01 연료 잔량](./A_기본/A01RemainingFuel.kt) | `val`, `var`, `if` 표현식 | `if`는 값을 반환합니다. 불필요한 `var`를 줄입니다. |
| [A02 화물 무게](./A_기본/A02CargoWeight.kt) | 타입 추론, `Int`/`Double` | Kotlin은 숫자 타입을 자동 확대하지 않습니다. |
| [A03 드론 호출부호](./A_기본/A03DroneCallSign.kt) | 문자열 템플릿, 표현식 본문 | `$name`과 `${expression}` 차이를 익힙니다. |
| [A04 배송비](./A_기본/A04DeliveryFee.kt) | `if` 표현식, 비교 | 임시 변수 없이 결과를 바로 반환합니다. |
| [A05 우선순위](./A_기본/A05PriorityLevel.kt) | `when`, `in`, 범위 | 범위 경계를 빠뜨리지 않습니다. |
| [A06 이륙 가능](./A_기본/A06CanLaunch.kt) | `Boolean`, `&&`, `\|\|` | 조건식 자체를 반환합니다. |
| [A07 경로 마커](./A_기본/A07RouteMarkers.kt) | `until`, `step`, `joinToString` | 범위도 순회 가능한 객체입니다. |
| [A08 배터리 사이클](./A_기본/A08BatteryCycles.kt) | `while`, 지역 `var` | 종료 조건을 명확히 둡니다. |
| [A09 창고 코드](./A_기본/A09WarehouseCode.kt) | `when`, `Char` 정규화 | 입력을 먼저 정규화하면 분기가 줄습니다. |
| [A10 라벨 포맷](./A_기본/A10LabelFormat.kt) | 기본·이름 인자 | 호출부 가독성과 기본값 정책을 익힙니다. |
| [A11 수신자 이름](./B_중급/A11RecipientName.kt) | `?.`, `?:`, `trim` | `null`과 빈 문자열은 다릅니다. |
| [A12 센서 파싱](./B_중급/A12SensorParse.kt) | `toIntOrNull`, `takeIf` | 실패를 예외 대신 `null`로 모델링합니다. |
| [A13 유효 주문](./B_중급/A13ValidOrders.kt) | `filter`, `distinct`, `sorted` | 체인 순서가 결과와 비용에 영향을 줍니다. |
| [A14 화물 라벨](./B_중급/A14CargoLabels.kt) | `mapIndexed` | 변환 결과 타입이 원본과 달라도 됩니다. |
| [A15 온도 요약](./B_중급/A15TempSummary.kt) | `data class`, 집계 | 빈 목록 정책을 반환 타입에 드러냅니다. |
| [A16 재고 합치기](./B_중급/A16MergeStock.kt) | `Map`, `MutableMap` | 내부는 mutable, 외부는 읽기 전용. |
| [A17 구역 분류](./B_중급/A17ZoneGrouping.kt) | `groupBy`, `mapValues` | `Map<K, List<T>>` 중간 타입을 이해합니다. |
| [A18 최고 점수](./B_중급/A18TopPilot.kt) | Comparator, `sortedWith` | 1차·2차 정렬 기준을 명시합니다. |
| [A19 중복 제거](./B_중급/A19UniqueTags.kt) | `Set`, 삽입 순서 | List와 Set의 역할 차이를 압니다. |
| [A20 좌표 분해](./B_중급/A20CoordinatePair.kt) | `Pair`, 구조 분해 | `(x, y)` 분해 할당을 익힙니다. |
| [A21 드론 상태](./C_고급/A21DroneState.kt) | 클래스, `private set` | 변경 경로를 메서드로 제한합니다. |
| [A22 배송 기록](./C_고급/A22DeliveryLog.kt) | `data class`, `copy` | `==`는 값, `===`는 참조입니다. |
| [A23 드론 등급](./C_고급/A23DroneGrade.kt) | `enum class` | enum은 상태와 동작을 가질 수 있습니다. |
| [A24 송신기](./C_고급/A24Beacon.kt) | `interface`, 다형성 | 호출자는 구체 클래스를 몰라도 됩니다. |
| [A25 배송 대상](./C_고급/A25DeliveryTarget.kt) | `sealed class`, 완전 `when` | `else` 없이 모든 경우를 검사합니다. |
| [A26 측정 가능](./C_고급/A26MeasurableCargo.kt) | 추상 클래스 | 공통 계약과 구현을 분리합니다. |
| [A27 제네릭 박스](./C_고급/A27GenericBox.kt) | generics, 타입 파라미터 | 타입을 파라미터로 받는 이유를 압니다. |
| [A28 슬롯 확장](./C_고급/A28SlotExtension.kt) | 확장 함수 | 상속 없이 도메인 표현을 추가합니다. |
| [A29 변환기](./D_최고급/A29TransformPipeline.kt) | 함수 타입, 람다 | `(T) -> R`도 타입입니다. |
| [A30 설정 빌더](./D_최고급/A30ConfigBuilder.kt) | `apply`, `let` | 스코프 함수별 반환값 차이를 구분합니다. |
| [A31 지연 초기화](./D_최고급/A31LazyCache.kt) | `by lazy` | 첫 접근 시에만 계산됩니다. |
| [A32 지연 시퀀스](./D_최고급/A32LazySequence.kt) | `Sequence`, `asSequence` | eager List와 lazy Sequence 차이를 압니다. |
| [A33 워커 스레드](./D_최고급/A33WorkerThread.kt) | `Thread`, `join` | 메인과 서브 스레드를 분리·동기화합니다. |
| [A34 공유 카운터](./D_최고급/A34SharedCounter.kt) | `synchronized` | 공유 가변 상태는 반드시 보호합니다. |
| [A35 작업 큐](./D_최고급/A35TaskQueue.kt) | 생산자·소비자, 동기화 | 스레드 간 안전한 핸드오프를 익힙니다. |
| [A36 배송 파이프라인](./D_최고급/A36DeliveryPipeline.kt) | 종합 파이프라인 | 파싱→필터→정렬→포맷을 타입과 함께 설명합니다. |

## 권장 반복 학습법

1. **첫 풀이:** 익숙한 방식으로 `check(...)`를 통과시킵니다.
2. **Kotlin식 리팩터링:** 불필요한 `var`, `!!`, 수동 반복을 줄입니다.
3. **설명:** 입력·출력 타입과 빈 값/스레드 정책을 소리 내어 설명합니다.
4. **변형:** 테스트 값을 하나 추가하고 요구사항을 조금 바꿔 다시 풉니다.
5. **복습:** 다음 날 파일을 초기 상태로 되돌려 힌트 없이 다시 작성합니다.

---

## 1단계 — 값과 타입 (기본)

### A01. 연료 잔량
- 문법: `val`, `var`, `if` 표현식
- `remainingFuel(current, used)` — 음수면 `0`
- 예: `remainingFuel(80, 25) == 55`

### A02. 화물 무게 합
- 문법: `Int`, `Double`, 명시적 변환
- kg 정수 목록의 합을 톤(`Double`)으로 반환 (`/ 1000.0`)
- 예: `totalTons(listOf(500, 500)) == 1.0`

### A03. 드론 호출 부호
- 문법: 문자열 템플릿, 표현식 본문
- 예: `droneCallSign("ALPHA", 3) == "ALPHA-03"` (번호는 2자리 zero-pad)

### A04. 배송비 계산
- 문법: `if` 표현식
- 무게 5kg 이하면 3000, 초과면 `3000 + (무게-5)*500`
- 예: `deliveryFee(5) == 3000`, `deliveryFee(7) == 4000`

### A05. 우선순위 등급
- 문법: `when`, `in`
- `0..24 LOW`, `25..49 NORMAL`, `50..74 HIGH`, `75..100 URGENT`, 그 외 `INVALID`

### A06. 이륙 가능 여부
- 문법: Boolean 논리
- 배터리 ≥ 40 이고 풍속 ≤ 12 이고 화물 잠금이 true일 때만 `true`

### A07. 경로 마커
- 문법: `until`/`step` 또는 범위, `joinToString`
- `0`부터 `limit` 미만까지 `step` 간격: 예 `routeMarkers(10, 3) == "0-3-6-9"`

### A08. 배터리 충전 사이클
- 문법: `while`
- 현재 `charge`에서 한 번에 `+rate`로 `target` 이상이 될 때까지 횟수 (이미 이상이면 0)

### A09. 창고 코드
- 문법: `when`, `Char`
- `N/n→NORTH`, `S/s→SOUTH`, `E/e→EAST`, `W/w→WEST`, 그 외 `UNKNOWN`

### A10. 라벨 포맷
- 문법: 기본 인자, 이름 있는 인자
- `formatLabel(id, prefix = "PKG", upper = true)` → `"PKG-ID"` 형태, `upper=false`면 id 소문자 유지

---

## 2단계 — null과 컬렉션 (중급)

### A11. 수신자 이름 정규화
- `null`/공백 → `"GUEST"`, 아니면 trim + 대문자 (`?.`/`?:`)

### A12. 센서값 파싱
- 문자열 → `0..100` Int, 실패/`범위밖` → `null` (`toIntOrNull`, `takeIf`)

### A13. 유효 주문 ID
- 양수만, 중복 제거, 오름차순

### A14. 화물 이름표
- `mapIndexed`로 `"1. WATER"` 형식 (대문자)

### A15. 온도 요약
- `TempSummary(min, max, avg)` 또는 빈 목록이면 `null`

### A16. 재고 합치기
- 두 `Map<String, Int>` 합산, 원본 불변

### A17. 구역별 분류
- `Parcel(id, zone)` → `Map<String, List<String>>` (구역 → id 목록)

### A18. 최고 파일럿
- 점수 Map에서 최고점 이름, 동점이면 이름 오름차순

### A19. 태그 유일화
- 입력 순서 유지하며 중복 제거 (`LinkedHashSet` 또는 동등 결과)

### A20. 좌표 쌍
- `"x,y"` 파싱 → `Pair<Int, Int>?`, 구조 분해로 합 계산 함수도 작성

---

## 3단계 — 타입 모델링 (고급)

### A21. 드론 상태
- `Drone(name, battery)` — `fly(cost)` 성공 시 차감, `private set`

### A22. 배송 기록
- `DeliveryLog` data class + `markDelivered`는 `copy`로 상태만 변경

### A23. 드론 등급
- enum `SCOUT`/`HAULER`/`COMMAND` — 권한 숫자와 `canAccess(level)`

### A24. 비콘 송신
- `Beacon` 인터페이스 + `RadioBeacon`/`LaserBeacon` 서로 다른 접두사

### A25. 배송 대상
- sealed: `Home`/`Locker`/`Unknown` — 안내 문구, `else` 금지

### A26. 측정 가능 화물
- 추상 `Cargo`의 `volume()`을 `BoxCargo`/`CylinderCargo`에서 구현

### A27. 제네릭 박스
- `Box<T>` — `get`/`map`으로 다른 타입 박스로 변환

### A28. 슬롯 확장 함수
- `String.toSlotCode()` — 공백→`-`, 대문자, 연속 공백은 하이픈 하나

---

## 4단계 — 함수·스레드·종합 (최고급)

### A29. 변환 파이프라인
- `(List<Int>, (Int)->Int) -> List<Int>` — `map` 버전과 루프 버전

### A30. 설정 빌더
- `HubConfig`를 `apply`로 설정해 반환, nullable 이름을 `let`으로 표시 문자열화

### A31. 지연 캐시
- `by lazy`로 무거운 계산을 한 번만 수행 (호출 카운터로 검증)

### A32. 지연 시퀀스
- 큰 범위에서 조건에 맞는 첫 N개를 `Sequence`로 수집 (중간 전체 리스트 금지 권장)

### A33. 워커 스레드
- 메인에서 서브 `Thread`를 띄워 작업 결과를 담은 뒤 `join`으로 회수

### A34. 공유 카운터
- 여러 스레드가 같은 카운터를 증가 — `synchronized`로 정확한 합 보장

### A35. 작업 큐
- 생산자 스레드가 작업을 넣고, 소비자 스레드가 꺼내 처리 (종료 신호 포함)

### A36. 배송 결과 파이프라인
- `"드론:점수"` 파싱 → 70점 이상 → 점수↓·이름↑ 정렬 → `"1위 NAME(점수)"`

---

## 최종 보너스 — 미니 프로젝트

위 타입·함수를 조합해 콘솔형 물류 허브 프로그램을 만듭니다.

- 드론 등록/조회
- 배송 생성과 상태 변경
- 재고 추가·소비
- 파일럿 점수 순위
- 백그라운드 스레드에서 센서 폴링 시뮬레이션
- 잘못된 입력은 예외 없이 재입력

필수: `data class`, `enum`/`sealed`, 컬렉션 고차함수, null 안전성, 확장 함수, `Thread`를 각각 한 번 이상 사용.
