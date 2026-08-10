# 중급 단계 — null과 컬렉션

목표는 실패 가능성을 타입에 드러내고 컬렉션 변환을 선언적으로 작성하는 것입니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 11 | [A11 수신자 이름](./A11RecipientName.kt) | nullable, `?.`, `?:` |
| 12 | [A12 센서 파싱](./A12SensorParse.kt) | `toIntOrNull`, `takeIf` |
| 13 | [A13 유효 주문](./A13ValidOrders.kt) | `filter`, `distinct`, `sorted` |
| 14 | [A14 화물 라벨](./A14CargoLabels.kt) | `mapIndexed` |
| 15 | [A15 온도 요약](./A15TempSummary.kt) | `data class`, 집계 |
| 16 | [A16 재고 합치기](./A16MergeStock.kt) | `Map`, `MutableMap` |
| 17 | [A17 구역 분류](./A17ZoneGrouping.kt) | `groupBy`, `mapValues` |
| 18 | [A18 최고 파일럿](./A18TopPilot.kt) | Comparator, 다중 정렬 |
| 19 | [A19 태그 유일화](./A19UniqueTags.kt) | `Set`, 순서 유지 |
| 20 | [A20 좌표 분해](./A20CoordinatePair.kt) | `Pair`, 구조 분해 |

완료 기준: `!!` 없이 구현, 빈 컬렉션 처리, 각 컬렉션 체인의 중간 타입 설명.
