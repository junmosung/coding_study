package practice_by_agent

// B05. 경로 테이블
// 목표: STOP-i:name 리스트 + name→index Map.
// 문법: buildList, buildMap
// 규칙: Pair로 함께 반환.
// 예: Alpha,Beta → STOP-0/1 + index
// 금지: 외부 mutable 노출
// 문서: docs/11_IDIOMS_STYLE.md

fun buildRouteTable(stops: List<String>): Pair<List<String>, Map<String, Int>> {
    return emptyList<String>() to emptyMap() // TODO
}

fun main() {
    val (labels, index) = buildRouteTable(listOf("Alpha", "Beta"))
    check(labels == listOf("STOP-0:Alpha", "STOP-1:Beta"))
    check(index == mapOf("Alpha" to 0, "Beta" to 1))
    check(buildRouteTable(emptyList()) == emptyList<String>() to emptyMap<String, Int>())
    println("B05 통과")
}
