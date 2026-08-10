package practice_by_codex

// C59. 오류 복구 파이프라인
// raw를 Int로 파싱하고 양수인지 검증한 뒤 2배로 만드세요.
// NumberFormatException만 값 0으로 복구하고, 음수의 IllegalArgumentException은 failure로 유지합니다.
// 조건: runCatching, mapCatching, recoverCatching을 모두 사용하세요.
fun processMeasurement(raw: String): Result<Int> {
    return Result.failure(NotImplementedError("TODO")) // TODO
}

fun main() {
    check(processMeasurement("21").getOrNull() == 42)
    check(processMeasurement("not-number").getOrNull() == 0)
    check(processMeasurement("-1").exceptionOrNull() is IllegalArgumentException)
    println("C59 통과")
}
