package pratice_by_codex

// C07. 통신 카운트다운
// start부터 0 이상인 값까지 2씩 감소시켜 ", "로 연결하세요.
// start가 음수라면 빈 문자열을 반환합니다.
// 예: countdownByTwo(6) == "6, 4, 2, 0"
//     countdownByTwo(5) == "5, 3, 1"
// 조건: downTo, step, joinToString을 사용하세요.
fun countdownByTwo(start: Int): String {
    return "" // TODO
}

fun main() {
    check(countdownByTwo(6) == "6, 4, 2, 0")
    check(countdownByTwo(5) == "5, 3, 1")
    check(countdownByTwo(-1) == "")
    println("C07 통과")
}
