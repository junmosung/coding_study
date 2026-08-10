package practice_by_agent

// B07. 이동량
// 목표: 연속 좌표 차분 절대값.
// 문법: zipWithNext
// 규칙: 원소 <2면 empty.
// 예: [1,4,2] → [3,2]
// 금지: zip 오용으로 자기자신 쌍
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun moveDeltas(points: List<Int>): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(moveDeltas(listOf(1, 4, 2)) == listOf(3, 2))
    check(moveDeltas(listOf(5)) == emptyList<Int>())
    check(moveDeltas(emptyList()) == emptyList<Int>())
    println("B07 통과")
}
