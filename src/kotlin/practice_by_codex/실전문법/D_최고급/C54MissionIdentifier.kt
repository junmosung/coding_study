package practice_by_codex

// C54. 안전한 식별자
// 빈 문자열이나 앞뒤 공백이 포함된 값은 IllegalArgumentException으로 거절하세요.
// 조건: @JvmInline value class와 init 검증을 사용하세요.
@JvmInline
value class MissionIdentifier(val value: String) {
    init {
        // TODO
    }
}

fun missionLabel(id: MissionIdentifier): String = "MISSION-${id.value}"

fun main() {
    check(missionLabel(MissionIdentifier("M-101")) == "MISSION-M-101")
    check(runCatching { MissionIdentifier("") }.exceptionOrNull() is IllegalArgumentException)
    check(runCatching { MissionIdentifier(" M-1 ") }.exceptionOrNull() is IllegalArgumentException)
    println("C54 통과")
}
