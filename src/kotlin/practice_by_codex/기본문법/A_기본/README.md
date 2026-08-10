# 기본 단계 — 값과 제어 흐름

목표는 작은 요구사항을 Kotlin 함수로 정확하게 옮기는 것입니다. `C01`부터 순서대로 진행합니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 1 | [C01 산소 잔량](./C01RemainingOxygen.kt) | `val`, 산술 연산, `if` 표현식 |
| 2 | [C02 호출 부호](./C02CallSign.kt) | 문자열 템플릿, 표현식 본문 |
| 3 | [C03 거리 변환](./C03DistanceConverter.kt) | `Int`, `Double`, 명시적 변환 |
| 4 | [C04 착륙 허가](./C04LandingPermission.kt) | Boolean 표현식, `&&` |
| 5 | [C05 위험 등급](./C05RiskLevel.kt) | `when`, `in`, 범위 |
| 6 | [C06 행성 코드](./C06PlanetCode.kt) | `Char`, 입력 정규화, `when` |
| 7 | [C07 카운트다운](./C07CommunicationCountdown.kt) | `downTo`, `step`, `joinToString` |
| 8 | [C08 첫 신호](./C08FirstSignal.kt) | `for`, 인덱스, 조기 반환 |
| 9 | [C09 충전 횟수](./C09BatteryCharges.kt) | `while`, 상태 변화, 종료 조건 |

완료 기준: 모든 `check` 통과, 경계값 설명, 불필요한 `var`와 Boolean 분기 제거.
