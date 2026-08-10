package pratice_by_agent

// B04. 로그 빌더
// 이벤트 목록을 "1) event\n2) event" 형식 문자열로 만드세요.
// 빈 목록이면 "(empty)"를 반환하세요.
// 조건: buildString을 사용하세요.
fun buildEventLog(events: List<String>): String {
    return "" // TODO
}

fun main() {
    check(buildEventLog(listOf("boot", "ready")) == "1) boot\n2) ready")
    check(buildEventLog(emptyList()) == "(empty)")
    println("B04 통과")
}
