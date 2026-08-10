package pratice_by_codex

data class CrewMember(val name: String, val role: String)

// C17. 대원 직군 분류
// 대원들을 role별로 묶되 Map의 값에는 대원 이름만 담으세요.
// 각 직군 안의 이름 순서는 입력 순서를 유지합니다.
// 조건: groupBy와 mapValues를 사용하세요.
fun groupCrewByRole(crew: List<CrewMember>): Map<String, List<String>> {
    return emptyMap() // TODO
}

fun main() {
    val crew = listOf(
        CrewMember("Neo", "PILOT"),
        CrewMember("Trinity", "ENGINEER"),
        CrewMember("Morpheus", "PILOT"),
    )
    check(groupCrewByRole(crew) == mapOf("PILOT" to listOf("Neo", "Morpheus"), "ENGINEER" to listOf("Trinity")))
    println("C17 통과")
}
