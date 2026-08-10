package practice_by_agent

// B04. 로그 빌더
// 목표: 1) e\n2) e 형식. 빈 목록 (empty).
// 문법: buildString
// 규칙: 줄바꿈 \n.
// 예: buildEventLog(["boot","ready"])
// 금지: 문자열 + 루프만
// 문서: docs/11_IDIOMS_STYLE.md

fun buildEventLog(events: List<String>): String {
    return "" // TODO
}

fun main() {
    check(buildEventLog(listOf("boot", "ready")) == "1) boot\n2) ready")
    check(buildEventLog(emptyList()) == "(empty)")
    println("B04 통과")
}
