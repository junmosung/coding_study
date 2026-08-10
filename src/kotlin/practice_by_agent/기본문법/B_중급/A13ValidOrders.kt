package practice_by_agent

// A13. 유효 주문
// 목표: 양수만, 중복 제거, 오름차순. 원본 불변.
// 문법: filter, distinct, sorted
// 규칙: 체인 순서 의식.
// 예: [3,-1,2,3,0,2] → [2,3]
// 금지: 원본 mutable 변경
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun validOrderIds(ids: List<Int>): List<Int> {
    return emptyList() // TODO
}

fun main() {
    val input = listOf(3, -1, 2, 3, 0, 2)
    check(validOrderIds(input) == listOf(2, 3))
    check(input == listOf(3, -1, 2, 3, 0, 2))
    check(validOrderIds(emptyList()) == emptyList<Int>())
    println("A13 통과")
}
