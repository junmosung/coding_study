package practice_by_codex

data class MissionEvent(val code: String, val message: String)
typealias MissionEventHandler = (MissionEvent) -> Unit

// C43. 콜백 의미 부여
// handlers를 순서대로 호출하고 실제 호출 수를 반환하세요.
fun publishEvent(event: MissionEvent, handlers: List<MissionEventHandler>): Int {
    return 0 // TODO
}

fun main() {
    val received = mutableListOf<String>()
    val handlers: List<MissionEventHandler> = listOf(
        { received += it.code },
        { received += it.message },
    )
    check(publishEvent(MissionEvent("READY", "launch"), handlers) == 2)
    check(received == listOf("READY", "launch"))
    println("C43 통과")
}
