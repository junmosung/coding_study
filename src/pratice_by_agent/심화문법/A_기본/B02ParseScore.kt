package pratice_by_agent

// B02. 안전 파싱
// 문자열을 Int로 파싱하고 0..100 범위만 성공으로 다루세요.
// 변환 실패 또는 범위 밖이면 Result.failure를 반환하세요.
// 조건: runCatching 또는 Result를 사용하고, null 반환은 금지합니다.
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
