package practice_by_codex

// C49. Map 기반 설정
// 프로퍼티 이름과 같은 키를 values에서 읽도록 Map 프로퍼티 위임을 사용하세요.
class MissionSettings(private val values: Map<String, Any>) {
    val host: String = "" // TODO: by values
    val port: Int = 0 // TODO: by values
    val secure: Boolean = false // TODO: by values
}

fun main() {
    val settings = MissionSettings(
        mapOf("host" to "localhost", "port" to 8080, "secure" to true)
    )
    check(settings.host == "localhost")
    check(settings.port == 8080)
    check(settings.secure)
    println("C49 통과")
}
