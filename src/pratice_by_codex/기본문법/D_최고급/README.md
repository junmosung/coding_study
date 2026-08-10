# 최고급 단계 — 함수 조합과 실전 파이프라인

목표는 함수를 값처럼 다루고 Kotlin 표준 라이브러리로 복합 요구사항을 명확하게 조합하는 것입니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 25 | [C25 측정값 변환](./C25MeasurementTransformer.kt) | 함수 타입, 고차 함수, 람다 |
| 26 | [C26 안전한 재시도](./C26RetryAction.kt) | 함수 주입, 부수 효과, 조기 반환 |
| 27 | [C27 호출 부호 확장](./C27CallSignExtension.kt) | 확장 함수, 정규식 |
| 28 | [C28 설정 생성기](./C28MissionConfig.kt) | `apply`, receiver |
| 29 | [C29 대원 표시](./C29CrewDisplay.kt) | `let`, nullable 변환 |
| 30 | [C30 결과 파이프라인](./C30ExplorationPipeline.kt) | `mapNotNull`, 정렬, `mapIndexed` |

완료 기준: 파이프라인의 단계별 타입과 실패 제거 시점을 설명하고, 스코프 함수 사용 이유를 말할 수 있음.
