# 최고급 단계 — JVM 동시성 실전

기본문법의 `Thread`/`synchronized` 다음으로, 실전에서 쓰는 풀·원자변수·동시성 컬렉션을 다룹니다.

| 순서 | 문제 | 집중 문법 |
|---:|---|---|
| 23 | [B23 스레드 풀](./B23ThreadPool.kt) | `ExecutorService` |
| 24 | [B24 Future 수집](./B24FutureCollect.kt) | `Future` |
| 25 | [B25 원자 카운터](./B25AtomicCounter.kt) | `AtomicInteger` |
| 26 | [B26 동시성 재고](./B26ConcurrentStock.kt) | `ConcurrentHashMap` |
| 27 | [B27 병렬 합산](./B27ParallelSum.kt) | 분할·병합 |
| 28 | [B28 관제 파이프라인](./B28TowerPipeline.kt) | 종합 |

완료 기준: 직접 `Thread`를 만드는 것과 풀/`Atomic*`을 쓰는 상황을 구분해서 설명.
