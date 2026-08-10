package pratice_by_codex

class MissionConfig {
    var destination: String = ""
    var crewSize: Int = 0
    var emergencyMode: Boolean = false
}

// C28. 설정 생성기
// MissionConfig를 생성하고 전달받은 세 값을 프로퍼티에 설정해 반환하세요.
// 조건: 생성 직후 apply 스코프 함수를 사용하세요.
fun createMissionConfig(
    destination: String,
    crewSize: Int,
    emergencyMode: Boolean,
): MissionConfig {
    return MissionConfig() // TODO
}

fun main() {
    val config = createMissionConfig("Mars", 4, true)
    check(config.destination == "Mars")
    check(config.crewSize == 4)
    check(config.emergencyMode)
    println("C28 통과")
}
