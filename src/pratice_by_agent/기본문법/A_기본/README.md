# 기본 단계 — 값과 제어 흐름

목표는 작은 요구사항을 Kotlin 함수로 정확하게 옮기는 것입니다. `A01`부터 순서대로 진행합니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 1 | [A01 연료 잔량](./A01RemainingFuel.kt) | `val`, 산술, `if` 표현식 |
| 2 | [A02 화물 무게](./A02CargoWeight.kt) | `Int`, `Double`, 명시적 변환 |
| 3 | [A03 드론 호출부호](./A03DroneCallSign.kt) | 문자열 템플릿, 표현식 본문 |
| 4 | [A04 배송비](./A04DeliveryFee.kt) | `if` 표현식 |
| 5 | [A05 우선순위](./A05PriorityLevel.kt) | `when`, `in`, 범위 |
| 6 | [A06 이륙 가능](./A06CanLaunch.kt) | Boolean, `&&` |
| 7 | [A07 경로 마커](./A07RouteMarkers.kt) | 범위, `step`, `joinToString` |
| 8 | [A08 배터리 사이클](./A08BatteryCycles.kt) | `while`, 상태 변화 |
| 9 | [A09 창고 코드](./A09WarehouseCode.kt) | `Char`, `when` |
| 10 | [A10 라벨 포맷](./A10LabelFormat.kt) | 기본·이름 있는 인자 |

완료 기준: 모든 `check` 통과, 경계값 설명, 불필요한 `var`와 Boolean 분기 제거.
