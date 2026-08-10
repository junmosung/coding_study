package pratice_by_agent

import java.util.concurrent.atomic.AtomicInteger

// B25. 원자적 요청 카운터
// 여러 스레드에서 bump를 호출해도 정확한 총합이 나와야 합니다.
// 조건: AtomicInteger 사용. synchronized 금지.
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
