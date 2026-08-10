package practice_by_agent

// B28. 관제 파이프라인
// 목표: '이름:작업수'→≥3→작업↓이름↑→'#n NAME (n jobs)'.
// 문법: mapNotNull, filter, sortedWith, mapIndexed
// 규칙: for·!! 금지.
// 예: Neo5,Trinity5,Mouse3
// 금지: for, !!
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

data class DroneJobs(val name: String, val jobs: Int)

fun towerRanking(rawResults: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val input = listOf(
        "Neo:5",
        "bad",
        "Trinity:5",
        "Morpheus:2",
        ":9",
        "Tank:x",
        "Mouse:3",
        "Apoc:1",
    )
    check(
        towerRanking(input) == listOf(
            "#1 Neo (5 jobs)",
            "#2 Trinity (5 jobs)",
            "#3 Mouse (3 jobs)",
        )
    )
    check(towerRanking(emptyList()) == emptyList<String>())
    println("B28 통과")
}
