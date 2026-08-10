package pratice_by_agent

// B05. 경로 테이블 빌더
// 정류장 이름 목록을 받아
// 1) ["STOP-0:A", "STOP-1:B", ...] 리스트
// 2) 이름 → 인덱스 Map
// 을 Pair로 반환하세요.
// 조건: buildList와 buildMap을 사용하세요.
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
