# 고급 단계 — 객체와 타입 모델링

목표는 요구사항의 상태, 역할, 가능한 경우의 수를 Kotlin 타입으로 표현하는 것입니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 21 | [A21 드론 상태](./A21DroneState.kt) | 클래스, `private set` |
| 22 | [A22 배송 기록](./A22DeliveryLog.kt) | `data class`, `copy` |
| 23 | [A23 드론 등급](./A23DroneGrade.kt) | `enum class` |
| 24 | [A24 비콘](./A24Beacon.kt) | `interface`, 다형성 |
| 25 | [A25 배송 대상](./A25DeliveryTarget.kt) | `sealed class`, 완전 `when` |
| 26 | [A26 측정 화물](./A26MeasurableCargo.kt) | 추상 클래스, 상속 |
| 27 | [A27 제네릭 박스](./A27GenericBox.kt) | generics |
| 28 | [A28 슬롯 확장](./A28SlotExtension.kt) | 확장 함수 |

완료 기준: 객체가 스스로 유효한 상태를 지키며, 선택한 타입 모델의 이유를 설명할 수 있음.
