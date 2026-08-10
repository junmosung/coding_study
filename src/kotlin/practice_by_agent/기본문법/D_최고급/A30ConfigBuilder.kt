package practice_by_agent

// A30. 설정 빌더
// 목표: apply로 HubConfig 설정. let으로 nullable 이름 표시.
// 문법: apply, let
// 규칙: !! 금지. 없으면 HUB:UNNAMED.
// 예: displayHubName("  East ")=="HUB:East"
// 금지: 스코프 함수 중첩 남발
// 문서: docs/07_EXTENSIONS_SCOPE_DELEGATION.md

class HubConfig {
    var name: String = ""
    var maxDrones: Int = 0
    var open: Boolean = false
}

fun buildHubConfig(name: String, maxDrones: Int, open: Boolean): HubConfig {
    return HubConfig() // TODO
}

fun displayHubName(name: String?): String {
    return "" // TODO
}

fun main() {
    val config = buildHubConfig("Seoul", 12, true)
    check(config.name == "Seoul")
    check(config.maxDrones == 12)
    check(config.open)
    check(displayHubName("  East ") == "HUB:East")
    check(displayHubName(null) == "HUB:UNNAMED")
    println("A30 통과")
}
