package practice_by_agent

// B03. 결과 변환
// 목표: 성공 SCORE:n, 실패 SCORE:NA.
// 문법: Result.map / getOrElse / fold
// 규칙: !! 금지. parseScoreB03 사용.
// 예: formatScore("75")=="SCORE:75"
// 금지: isSuccess 분기만 남발
// 문서: docs/08_ERRORS_RESULT.md

fun parseScoreB03(raw: String): Result<Int> {
    return Result.failure(IllegalArgumentException("TODO"))
}

fun formatScore(raw: String): String {
    return "" // TODO
}

fun main() {
    check(formatScore("75") == "SCORE:75")
    check(formatScore("101") == "SCORE:NA")
    check(formatScore("x") == "SCORE:NA")
    println("B03 통과")
}
