package practice_by_agent

// B06. 구간 평균
// 목표: size 윈도우 평균 Double 리스트.
// 문법: windowed
// 규칙: size 부적절하면 empty.
// 예: [1,2,3,4],2 → [1.5,2.5,3.5]
// 금지: 수동 이중 인덱스만
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun windowAverages(values: List<Int>, size: Int): List<Double> {
    return emptyList() // TODO
}

fun main() {
    check(windowAverages(listOf(1, 2, 3, 4), 2) == listOf(1.5, 2.5, 3.5))
    check(windowAverages(listOf(1, 2), 3) == emptyList<Double>())
    check(windowAverages(listOf(10), 1) == listOf(10.0))
    println("B06 통과")
}
