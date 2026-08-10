package practice_by_agent

// A34. 공유 카운터
// 목표: 멀티스레드 increment 정확한 합.
// 문법: synchronized
// 규칙: 레이스 없이 10*1000.
// 예: value==10_000
// 금지: 동기화 없는 ++
// 문서: docs/10_JAVA_INTEROP.md

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
