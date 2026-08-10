package practice_by_agent

// B02. 안전 파싱
// 목표: 0..100 Int만 Result.success.
// 문법: runCatching, Result
// 규칙: null 반환 금지.
// 예: parseScore("80").getOrNull()==80
// 금지: nullable 반환으로 대체
// 문서: docs/08_ERRORS_RESULT.md

fun parseScore(raw: String): Result<Int> {
    return Result.failure(IllegalArgumentException("TODO"))
}

fun main() {
    check(parseScore("80").getOrNull() == 80)
    check(parseScore("0").isSuccess)
    check(parseScore("100").isSuccess)
    check(parseScore("101").isFailure)
    check(parseScore("-1").isFailure)
    check(parseScore("nope").isFailure)
    println("B02 통과")
}
