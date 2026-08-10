# 고급 단계 — 객체와 타입 모델링

목표는 요구사항의 상태, 역할, 가능한 경우의 수를 Kotlin 타입으로 표현하는 것입니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 19 | [C19 탐사 로봇](./C19ExplorerRobot.kt) | 클래스, 캡슐화, `private set` |
| 20 | [C20 임무 기록](./C20MissionLog.kt) | `data class`, `copy`, `==`와 `===` |
| 21 | [C21 승무원 등급](./C21CrewRank.kt) | `enum class`, 프로퍼티와 메서드 |
| 22 | [C22 송신 장치](./C22Transmitter.kt) | 인터페이스, 구현, 다형성 |
| 23 | [C23 탐사 대상](./C23SpaceTarget.kt) | `sealed class`, 완전한 `when` |
| 24 | [C24 우주 물체](./C24MeasurableSpaceObject.kt) | 추상 클래스, 상속, `override` |

완료 기준: 객체가 스스로 유효한 상태를 지키며, 각 문제에서 선택한 타입 모델의 이유 설명.
