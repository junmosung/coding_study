package practice_by_agent

// B25. 원자 카운터
// 목표: bump 멀티스레드 정확 합.
// 문법: AtomicInteger
// 규칙: synchronized 금지.
// 예: total()==8000
// 금지: synchronized
// 문서: docs/10_JAVA_INTEROP.md

import java.util.concurrent.atomic.AtomicInteger

class RequestCounter {
    private val count = AtomicInteger(0)

    fun bump() {
        // TODO
    }

    fun total(): Int = 0 // TODO
}

fun main() {
    val counter = RequestCounter()
    val threads = List(8) {
        Thread {
            repeat(1000) { counter.bump() }
        }
    }
    threads.forEach { it.start() }
    threads.forEach { it.join() }
    check(counter.total() == 8_000)
    println("B25 통과")
}
