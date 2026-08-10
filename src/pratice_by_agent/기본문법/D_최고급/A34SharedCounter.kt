package pratice_by_agent

// A34. 공유 카운터
// SharedCounter.increment는 여러 스레드에서 동시에 호출되어도 정확히 누적되어야 합니다.
// 조건: synchronized(this) 또는 @Synchronized로 임계 구역을 보호하세요.
class SharedCounter {
    var value: Int = 0
        private set

    fun increment() {
        // TODO
    }
}

fun main() {
    val counter = SharedCounter()
    val threads = List(10) {
        Thread {
            repeat(1000) { counter.increment() }
        }
    }
    threads.forEach { it.start() }
    threads.forEach { it.join() }
    check(counter.value == 10_000)
    println("A34 통과")
}
