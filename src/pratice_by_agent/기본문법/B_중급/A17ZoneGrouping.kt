package pratice_by_agent

data class Parcel(val id: String, val zone: String)

// A17. 구역별 분류
// Parcel 목록을 구역별 id 목록 Map으로 변환하세요.
// 반환 타입: Map<String, List<String>>
// 조건: groupBy와 mapValues를 사용하세요.
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
