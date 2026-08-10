package practice_by_codex

// C18. 최고 점수 대원
// 최고 점수를 가진 대원의 이름을 반환하세요.
// 동점이면 이름이 사전순으로 빠른 대원을 선택하고, 빈 Map이면 null을 반환합니다.
// 조건: 정렬 또는 maxWithOrNull을 사용하고 입력 Map은 변경하지 마세요.
fun topCrewName(scores: Map<String, Int>): String? {
    return null // TODO
}

fun main() {
    check(topCrewName(mapOf("Neo" to 90, "Trinity" to 95)) == "Trinity")
    check(topCrewName(mapOf("Zed" to 90, "Amy" to 90)) == "Amy")
    check(topCrewName(emptyMap()) == null)
    println("C18 통과")
}
