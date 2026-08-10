package practice_by_agent

// B23. 스레드 풀
// 목표: pool에 tasks개 실행 후 완료 수 반환.
// 문법: ExecutorService, shutdown, awaitTermination
// 규칙: Thread() 직접 생성 금지.
// 예: runInPool(4,20)==20
// 금지: Thread() 수동 생성
// 문서: docs/10_JAVA_INTEROP.md

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun runInPool(poolSize: Int, tasks: Int): Int {
    return 0 // TODO
}

fun main() {
    val done = runInPool(poolSize = 4, tasks = 20)
    check(done == 20)
    println("B23 통과")
}
