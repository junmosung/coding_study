# 기본 문법 — A01~A36

**드론 물류 센터**를 조금씩 조립하며 Kotlin 핵심 문법을 익힙니다.
진입 전 [`GRAMMAR_MAP.md`](../GRAMMAR_MAP.md)의 ★★★ 항목과 [`docs/01`](../../docs/01_BASIC_SYNTAX.md)·[`02`](../../docs/02_NULL_SAFETY.md)를 훑어보세요.

## 단계 목표

| 단계 | 문제 | 목표 | 완료 기준 |
|---|---:|---|---|
| [A · 기본](./A_기본/README.md) | A01~A10 | 값·함수·조건·범위·반복 | 표현식으로 결과를 반환하고 불필요한 `var`를 제거 |
| [B · 중급](./B_중급/README.md) | A11~A20 | null·컬렉션·Map·정렬 | `!!` 없이 빈 값 정책을 타입에 드러냄 |
| [C · 고급](./C_고급/README.md) | A21~A28 | 클래스·enum·sealed·제네릭 | 상태/경우의 수를 타입으로 모델링 |
| [D · 최고급](./D_최고급/README.md) | A29~A36 | 고차함수·스코프·Sequence·Thread | 파이프라인과 스레드 동기화를 설명 |

## A · 기본 — 값과 제어 흐름

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [A01 연료 잔량](./A_기본/A01RemainingFuel.kt) | `current - used`, 음수면 `0` | `if` 표현식 / `coerceAtLeast` |
| [A02 화물 무게](./A_기본/A02CargoWeight.kt) | kg 합을 톤(`Double`)으로 변환 | `Int`→`Double`, 정수 나눗셈 함정 |
| [A03 호출 부호](./A_기본/A03DroneCallSign.kt) | `"NAME-NN"` (2자리 zero-pad) | 문자열 템플릿, 표현식 본문 `=` |
| [A04 배송비](./A_기본/A04DeliveryFee.kt) | 5kg 이하 3000, 초과 시 가중 요금 | `if` 표현식 즉시 반환 |
| [A05 우선순위](./A_기본/A05PriorityLevel.kt) | 구간별 등급, 범위 밖 `INVALID` | `when` + `in` 범위 |
| [A06 이륙 가능](./A_기본/A06CanLaunch.kt) | 배터리·풍속·잠금 동시 충족 | Boolean 식 자체 반환 |
| [A07 경로 마커](./A_기본/A07RouteMarkers.kt) | `0`부터 `limit` 미만 step 간격 연결 | 범위, `joinToString` |
| [A08 충전 사이클](./A_기본/A08BatteryCycles.kt) | `rate`씩 더해 `target` 도달 횟수 | `while`, 종료 조건 |
| [A09 창고 코드](./A_기본/A09WarehouseCode.kt) | N/S/E/W → 방향명 (대소문자 무시) | `Char` 정규화 + `when` |
| [A10 라벨 포맷](./A_기본/A10LabelFormat.kt) | `prefix-id`, 기본·이름 있는 인자 | default / named args |

## B · 중급 — null과 컬렉션

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [A11 수신자 이름](./B_중급/A11RecipientName.kt) | null/공백 → `GUEST`, 아니면 trim+대문자 | `?.` `?:` |
| [A12 센서 파싱](./B_중급/A12SensorParse.kt) | `0..100`만 성공, 실패는 `null` | `toIntOrNull`, `takeIf` |
| [A13 유효 주문](./B_중급/A13ValidOrders.kt) | 양수·중복제거·오름차순, 원본 불변 | `filter` `distinct` `sorted` |
| [A14 화물 라벨](./B_중급/A14CargoLabels.kt) | `"1. WATER"` 형식 | `mapIndexed` |
| [A15 온도 요약](./B_중급/A15TempSummary.kt) | min/max/avg, 빈 목록은 `null` | `data class`, `OrNull` 집계 |
| [A16 재고 합치기](./B_중급/A16MergeStock.kt) | 두 Map 합산, 원본 유지 | `MutableMap` → 읽기 전용 반환 |
| [A17 구역 분류](./B_중급/A17ZoneGrouping.kt) | zone → id 목록 | `groupBy` `mapValues` |
| [A18 최고 파일럿](./B_중급/A18TopPilot.kt) | 최고점, 동점 시 이름 오름차순 | Comparator / `maxWithOrNull` |
| [A19 태그 유일화](./B_중급/A19UniqueTags.kt) | 순서 유지 중복 제거 | `LinkedHashSet` / 동등 연산 |
| [A20 좌표 분해](./B_중급/A20CoordinatePair.kt) | `"x,y"` → `Pair?`, 합 계산 | 구조 분해 |

## C · 고급 — 타입 모델링

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [A21 드론 상태](./C_고급/A21DroneState.kt) | `fly(cost)` 성공 시에만 차감 | 클래스, `private set` |
| [A22 배송 기록](./C_고급/A22DeliveryLog.kt) | 상태만 `DELIVERED`인 복사본 | `data class` `copy`, `==`/`===` |
| [A23 드론 등급](./C_고급/A23DroneGrade.kt) | 권한 level + `canAccess` | `enum class` |
| [A24 비콘](./C_고급/A24Beacon.kt) | Radio/Laser 서로 다른 접두사 | `interface`, 다형성 |
| [A25 배송 대상](./C_고급/A25DeliveryTarget.kt) | Home/Locker/Unknown 안내문 | `sealed class`, else 없는 `when` |
| [A26 측정 화물](./C_고급/A26MeasurableCargo.kt) | Box/Cylinder `volume()` | 추상 클래스, 실수 연산 |
| [A27 제네릭 박스](./C_고급/A27GenericBox.kt) | `Box<T>.map` → `Box<R>` | 타입 파라미터 |
| [A28 슬롯 확장](./C_고급/A28SlotExtension.kt) | 공백→`-`, 대문자 슬롯 코드 | 확장 함수 |

## D · 최고급 — 함수·지연·스레드

| 문제 | 기획 명세 | 반드시 캐치할 문법 |
|---|---|---|
| [A29 변환기](./D_최고급/A29TransformPipeline.kt) | map 버전 + 루프 버전 | `(Int) -> Int` 고차 함수 |
| [A30 설정 빌더](./D_최고급/A30ConfigBuilder.kt) | `apply`로 설정, `let`으로 표시 | 스코프 함수 반환값 차이 |
| [A31 지연 캐시](./D_최고급/A31LazyCache.kt) | 첫 접근 1회만 계산 | `by lazy` |
| [A32 지연 시퀀스](./D_최고급/A32LazySequence.kt) | 조건 만족값 최대 N개 | `asSequence` (전체 filter 금지 권장) |
| [A33 워커 스레드](./D_최고급/A33WorkerThread.kt) | 서브 스레드 실행 후 `join` 회수 | `Thread`, 메인≠워커 |
| [A34 공유 카운터](./D_최고급/A34SharedCounter.kt) | 멀티스레드 정확한 합 | `synchronized` |
| [A35 작업 큐](./D_최고급/A35TaskQueue.kt) | 생산자·소비자 + POISON | wait/notify 또는 BlockingQueue |
| [A36 배송 파이프라인](./D_최고급/A36DeliveryPipeline.kt) | 파싱→≥70→정렬→`"n위"` | `mapNotNull` 체인, `!!`·for 금지 |

## 습관

- `val` 우선, 읽기 전용 컬렉션 우선
- `!!` 금지에 가깝게, 실패는 `null`/`Result`/예외 중 하나로 명시
- 스레드 문제는 여러 번 실행해 레이스 여부를 확인

다음 트랙: [심화 문법 B01~B28](../심화문법/README.md)
