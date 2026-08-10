package practice_by_agent

// A32. 지연 시퀀스
// 목표: 0 until limit 중 predicate 만족 최대 takeCount개.
// 문법: Sequence, asSequence
// 규칙: 전체 List를 먼저 filter하지 말 것(권장).
// 예: firstMatching(20,3){it%2==0} → [0,2,4]
// 금지: eager filter+take만
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun firstMatching(limit: Int, takeCount: Int, predicate: (Int) -> Boolean): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(firstMatching(20, 3) { it % 2 == 0 } == listOf(0, 2, 4))
    check(firstMatching(5, 10) { it > 2 } == listOf(3, 4))
    check(firstMatching(3, 0) { true } == emptyList<Int>())
    println("A32 통과")
}
