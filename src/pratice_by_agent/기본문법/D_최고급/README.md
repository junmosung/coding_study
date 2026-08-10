# 최고급 단계 — 함수 조합과 스레드

목표는 함수를 값처럼 다루고, JVM에서 **메인 스레드와 서브 스레드**를 분리·동기화하는 기본기를 익히는 것입니다.
(이 프로젝트는 Kotlin 표준 런타임만 사용하므로 Coroutine 대신 `Thread`/`synchronized`를 사용합니다.)

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 29 | [A29 변환기](./A29TransformPipeline.kt) | 함수 타입, 고차 함수 |
| 30 | [A30 설정 빌더](./A30ConfigBuilder.kt) | `apply`, `let` |
| 31 | [A31 지연 캐시](./A31LazyCache.kt) | `by lazy` |
| 32 | [A32 지연 시퀀스](./A32LazySequence.kt) | `Sequence` |
| 33 | [A33 워커 스레드](./A33WorkerThread.kt) | `Thread`, `join`, 메인 vs 서브 |
| 34 | [A34 공유 카운터](./A34SharedCounter.kt) | `synchronized` |
| 35 | [A35 작업 큐](./A35TaskQueue.kt) | 생산자·소비자 |
| 36 | [A36 배송 파이프라인](./A36DeliveryPipeline.kt) | 종합 컬렉션 파이프라인 |

완료 기준: 파이프라인 단계별 타입 설명, 스레드 문제에서 왜 `join`/`synchronized`가 필요한지 설명.
