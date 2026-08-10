# B · 중급 — 제네릭과 확장 API

| 순서 | 문제 | 구현 산출물 | 검증 관점 |
|---:|---|---|---|
| C39 | [범용 화물 상자](./C39CargoBox.kt) | `CargoBox<T>` | 서로 다른 T와 빈 상자 처리 |
| C40 | [최댓값 탐색](./C40GenericMaximum.kt) | 제약이 있는 제네릭 함수 | 숫자·문자열·빈 목록 테스트 |
| C41 | [생산자와 소비자](./C41ProducerConsumer.kt) | `Producer<out T>`, `Consumer<in T>` | 상·하위 타입 대입 가능 방향 확인 |
| C42 | [타입별 신호 추출](./C42ReifiedSignalFilter.kt) | reified 확장 함수 | 여러 런타임 타입 혼합 목록 처리 |
| C43 | [콜백 의미 부여](./C43EventCallback.kt) | 도메인 `typealias` | 시그니처 가독성과 실제 호환 타입 확인 |
| C44 | [거리 확장 프로퍼티](./C44ExtensionProperties.kt) | 계산형 확장 프로퍼티 | 상태 저장 불가능 확인 |
| C45 | [벡터 연산](./C45VectorOperators.kt) | 연산자 함수가 있는 값 타입 | 교환 법칙 여부와 잘못된 인덱스 처리 |
| C46 | [권한 중위 표현](./C46AccessInfix.kt) | 제한된 infix API | 일반 호출 문법과 가독성 비교 |

완료 후에는 제네릭 선언에서 값이 입력되는지 출력되는지 표시하고 변성을 결정합니다.
