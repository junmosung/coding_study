package practice_by_agent

// A36. 배송 파이프라인
// 목표: '이름:점수' 파싱→≥70→점수↓이름↑→'n위 NAME(점수)'.
// 문법: mapNotNull, filter, sortedWith, mapIndexed
// 규칙: for문·!! 금지.
// 예: Neo90,Trinity90,Mouse70 순위
// 금지: for, !!
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

data class PilotScore(val name: String, val score: Int)

fun deliveryRanking(rawResults: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val input = listOf(
        "Neo:90",
        "bad",
        "Trinity:90",
        "Morpheus:55",
        ":100",
        "Tank:not-number",
        "Mouse:70",
        "Apoc:69",
    )
    check(
        deliveryRanking(input) == listOf(
            "1위 Neo(90)",
            "2위 Trinity(90)",
            "3위 Mouse(70)",
        )
    )
    check(deliveryRanking(emptyList()) == emptyList<String>())
    println("A36 통과")
}
