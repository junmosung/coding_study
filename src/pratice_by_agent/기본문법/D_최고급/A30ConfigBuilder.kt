package pratice_by_agent

class HubConfig {
    var name: String = ""
    var maxDrones: Int = 0
    var open: Boolean = false
}

// A30. 설정 빌더
// buildHubConfig는 HubConfig를 생성한 뒤 apply 블록에서 프로퍼티를 설정하고 반환하세요.
// displayHubName은 nullable 이름이 있으면 trim 후 "HUB:{name}", 없으면 "HUB:UNNAMED"를 반환하세요.
// 조건: apply와 let을 사용하고 !!는 금지합니다.
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
