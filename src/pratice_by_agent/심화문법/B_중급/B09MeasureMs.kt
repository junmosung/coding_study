package pratice_by_agent

// B09. 인라인 타이머
// block을 실행하고 (결과, 경과 ms)를 반환하세요.
// 조건: inline 고차 함수로 선언하세요.
inline fun <T> measureMs(block: () -> T): Pair<T, Long> {
    return block() to 0L // TODO: 실제 경과 시간 측정
}

fun main() {
    val (value, elapsed) = measureMs {
        Thread.sleep(20)
        42
    }
    check(value == 42)
    check(elapsed >= 15)
    println("B09 통과 (elapsed=${elapsed}ms)")
}
