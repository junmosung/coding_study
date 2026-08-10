package pratice_by_agent

// A32. 지연 시퀀스
// 0 until limit 범위에서 predicate를 만족하는 값을 최대 takeCount개까지 모으세요.
// 조건: asSequence()를 사용하고, 전체 List를 먼저 filter하지 마세요.
fun firstMatching(limit: Int, takeCount: Int, predicate: (Int) -> Boolean): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(firstMatching(20, 3) { it % 2 == 0 } == listOf(0, 2, 4))
    check(firstMatching(5, 10) { it > 2 } == listOf(3, 4))
    check(firstMatching(3, 0) { true } == emptyList<Int>())
    println("A32 통과")
}
