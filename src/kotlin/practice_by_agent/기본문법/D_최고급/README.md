# D · 최고급 — 함수·지연·스레드

문서: [`docs/03`](../../../docs/03_FUNCTIONS_LAMBDAS.md), [`docs/07`](../../../docs/07_EXTENSIONS_SCOPE_DELEGATION.md), [`docs/10`](../../../docs/10_JAVA_INTEROP.md)

| # | 문제 | 문법 | 한 줄 명세 |
|---:|---|---|---|
| 29 | [A29](./A29TransformPipeline.kt) | 고차 함수 | map+루프 |
| 30 | [A30](./A30ConfigBuilder.kt) | `apply`/`let` | 설정·표시 |
| 31 | [A31](./A31LazyCache.kt) | `by lazy` | 1회 계산 |
| 32 | [A32](./A32LazySequence.kt) | `Sequence` | 지연 take |
| 33 | [A33](./A33WorkerThread.kt) | `Thread`/`join` | 메인≠워커 |
| 34 | [A34](./A34SharedCounter.kt) | `synchronized` | 공유 카운터 |
| 35 | [A35](./A35TaskQueue.kt) | 생산자·소비자 | POISON 종료 |
| 36 | [A36](./A36DeliveryPipeline.kt) | 종합 체인 | 순위 문자열 |

완료: 파이프라인 단계별 타입 + 왜 join/동기화가 필요한지 설명.
