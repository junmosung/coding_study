package pratice_by_agent

// B03. 결과 변환
// parseScoreB03로 파싱한 뒤 성공이면 "SCORE:n", 실패면 "SCORE:NA"를 반환하세요.
// 조건: Result.map / getOrElse 또는 fold를 사용하세요. !! 금지.
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
