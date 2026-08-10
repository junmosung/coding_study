package pratice_by_agent

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

// B23. 스레드 풀 실행
// tasks개 작업을 fixed thread pool(poolSize)에 넣고 모두 끝날 때까지 기다린 뒤
// 실행된 작업 수를 반환하세요.
// 조건: Executors + shutdown + awaitTermination 사용. Thread() 직접 생성 금지.
fun runInPool(poolSize: Int, tasks: Int): Int {
    return 0 // TODO
}

fun main() {
    val done = runInPool(poolSize = 4, tasks = 20)
    check(done == 20)
    println("B23 통과")
}
