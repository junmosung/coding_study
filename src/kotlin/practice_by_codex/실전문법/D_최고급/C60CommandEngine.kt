package practice_by_codex

sealed interface ExplorationCommand {
    data class Add(val name: String, val score: Int) : ExplorationCommand
    data class Top(val limit: Int) : ExplorationCommand
    data class Invalid(val raw: String) : ExplorationCommand
}

// C60. 탐사 명령 엔진
// "ADD 이름 점수"와 "TOP 개수"를 파싱하세요. 형식이 잘못되면 Invalid입니다.
fun parseExplorationCommand(raw: String): ExplorationCommand {
    return ExplorationCommand.Invalid(raw) // TODO
}

// ADD는 점수를 저장하고 "ADDED 이름", TOP은 점수 내림차순·이름 오름차순 결과를
// 쉼표로 연결합니다. Invalid는 "INVALID"를 출력합니다. 입력 순서대로 결과를 반환하세요.
fun runCommandEngine(rawCommands: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val output = runCommandEngine(
        listOf("ADD Neo 90", "ADD Trinity 95", "ADD Amy 95", "TOP 2", "BAD")
    )
    check(output == listOf("ADDED Neo", "ADDED Trinity", "ADDED Amy", "Amy(95), Trinity(95)", "INVALID"))
    check(parseExplorationCommand("ADD Neo x") is ExplorationCommand.Invalid)
    check(parseExplorationCommand("TOP 0") is ExplorationCommand.Invalid)
    println("C60 통과")
}
