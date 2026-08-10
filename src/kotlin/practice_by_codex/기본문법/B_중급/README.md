# 중급 단계 — null과 컬렉션

목표는 실패 가능성을 타입에 드러내고 컬렉션 변환을 선언적으로 작성하는 것입니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 10 | [C10 선장 별명](./C10CaptainNickname.kt) | nullable 타입, `?.`, `?:` |
| 11 | [C11 센서 파싱](./C11SensorParser.kt) | `toIntOrNull`, `takeIf` |
| 12 | [C12 예비 좌표](./C12BackupCoordinate.kt) | 엘비스 체이닝, null 정책 |
| 13 | [C13 대원 ID](./C13ValidCrewIds.kt) | `filter`, `distinct`, `sorted` |
| 14 | [C14 자원 이름표](./C14ResourceLabels.kt) | `mapIndexed`, 람다 |
| 15 | [C15 온도 보고서](./C15TemperatureReport.kt) | `data class`, 집계, `OrNull` |
| 16 | [C16 재고 합치기](./C16MergeInventory.kt) | `Map`, `MutableMap`, 구조 분해 |
| 17 | [C17 직군 분류](./C17CrewGrouping.kt) | `groupBy`, `mapValues` |
| 18 | [C18 최고 점수](./C18TopCrew.kt) | Comparator, 다중 정렬 |

완료 기준: `!!` 없이 구현, 빈 컬렉션 처리, 각 컬렉션 체인의 중간 타입 설명.
