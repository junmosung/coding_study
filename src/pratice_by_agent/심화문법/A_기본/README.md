# 기본 단계 — 표준 관용구

기본문법 다음으로, 실패 처리와 표준 라이브러리 빌더·집계를 익힙니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 1 | [B01 배송 검증](./B01ValidateShipment.kt) | `require`, `check` |
| 2 | [B02 안전 파싱](./B02ParseScore.kt) | `runCatching`, `Result` |
| 3 | [B03 결과 변환](./B03FormatScore.kt) | `Result.map` / `fold` |
| 4 | [B04 로그 빌더](./B04BuildLog.kt) | `buildString` |
| 5 | [B05 경로 테이블](./B05RouteTable.kt) | `buildList`, `buildMap` |
| 6 | [B06 구간 평균](./B06WindowAverage.kt) | `windowed` |
| 7 | [B07 이동량](./B07MoveDeltas.kt) | `zipWithNext` |
| 8 | [B08 누적 배터리](./B08BatteryFold.kt) | `fold`, `runningFold` |

완료 기준: 예외 vs `Result` 선택 이유를 설명할 수 있음.
