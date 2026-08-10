package practice_by_agent

// A17. 구역 분류
// 목표: Parcel 목록 → zone별 id 목록 Map.
// 문법: groupBy, mapValues
// 규칙: 반환 Map<String, List<String>>.
// 예: A→[P1,P3], B→[P2]
// 금지: 수동 이중 루프만 사용
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

data class Parcel(val id: String, val zone: String)

fun groupByZone(parcels: List<Parcel>): Map<String, List<String>> {
    return emptyMap() // TODO
}

fun main() {
    val parcels = listOf(
        Parcel("P1", "A"),
        Parcel("P2", "B"),
        Parcel("P3", "A"),
    )
    check(groupByZone(parcels) == mapOf("A" to listOf("P1", "P3"), "B" to listOf("P2")))
    println("A17 통과")
}
