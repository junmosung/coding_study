# 고급 단계 — DSL과 연산자

도메인 코드를 읽기 좋은 API로 만드는 문법을 익힙니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 17 | [B17 좌표 연산](./B17PointOps.kt) | `operator` |
| 18 | [B18 단위 infix](./B18CargoInfix.kt) | `infix` |
| 19 | [B19 관제탑 DSL](./B19TowerDsl.kt) | 람다 with receiver |
| 20 | [B20 라우트 invoke](./B20RouteInvoke.kt) | `invoke` |
| 21 | [B21 관제 사건](./B21TowerEvent.kt) | `sealed interface` |
| 22 | [B22 우선순위](./B22TicketComparable.kt) | `Comparable` |

완료 기준: 짧은 DSL을 설계하고 호출부만 보고 동작을 예측할 수 있음.
