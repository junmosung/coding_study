package practice_by_agent

// A18. 최고 파일럿
// 목표: 최고점 이름. 동점이면 이름 오름차순. 빈 Map은 null.
// 문법: Comparator, maxWithOrNull / sortedWith
// 규칙: 1차 점수, 2차 이름.
// 예: Neo90=Trinity90 → Neo
// 금지: 동점 무시
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun topPilot(scores: Map<String, Int>): String? {
    return null // TODO
}

fun main() {
    check(topPilot(mapOf("Neo" to 90, "Trinity" to 90, "Morpheus" to 80)) == "Neo")
    check(topPilot(mapOf("Tank" to 70)) == "Tank")
    check(topPilot(emptyMap()) == null)
    println("A18 통과")
}
