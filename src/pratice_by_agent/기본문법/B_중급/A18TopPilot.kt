package pratice_by_agent

// A18. 최고 파일럿
// 이름→점수 Map에서 최고 점수의 이름을 반환하세요.
// 동점이면 이름이 사전순으로 빠른 쪽을 선택하세요.
// 빈 Map이면 null을 반환하세요.
// 조건: maxWithOrNull 또는 sortedWith + firstOrNull 등을 사용하세요.
fun topPilot(scores: Map<String, Int>): String? {
    return null // TODO
}

fun main() {
    check(topPilot(mapOf("Neo" to 90, "Trinity" to 90, "Morpheus" to 80)) == "Neo")
    check(topPilot(mapOf("Tank" to 70)) == "Tank")
    check(topPilot(emptyMap()) == null)
    println("A18 통과")
}
