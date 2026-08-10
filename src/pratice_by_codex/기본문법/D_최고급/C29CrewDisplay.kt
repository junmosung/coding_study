package pratice_by_codex

data class AssignedCrew(val name: String, val role: String)

// C29. 안전한 사용자 표시
// crew가 있으면 "이름 (직군)"을, null이면 "미배정"을 반환하세요.
// 조건: let과 엘비스 연산자를 사용하고 if와 !!는 사용하지 마세요.
fun displayCrew(crew: AssignedCrew?): String {
    return "" // TODO
}

fun main() {
    check(displayCrew(AssignedCrew("Neo", "Pilot")) == "Neo (Pilot)")
    check(displayCrew(null) == "미배정")
    println("C29 통과")
}
