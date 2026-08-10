package practice_by_codex

// C35. 안전한 계산 결과
// 두 문자열을 Int로 변환해 a / b를 계산한 Result<Int>를 반환하세요.
// 숫자 변환 실패와 0으로 나누기는 모두 Result.failure가 되어야 합니다.
// 조건: try/catch를 직접 쓰지 말고 runCatching을 사용하세요.
fun safeDivide(a: String, b: String): Result<Int> {
    return Result.failure(NotImplementedError("TODO")) // TODO
}

fun main() {
    check(safeDivide("20", "4").getOrNull() == 5)
    check(safeDivide("x", "4").isFailure)
    check(safeDivide("20", "0").exceptionOrNull() is ArithmeticException)
    println("C35 통과")
}
