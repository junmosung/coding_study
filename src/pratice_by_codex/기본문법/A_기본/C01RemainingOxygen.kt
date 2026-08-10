package pratice_by_codex

// C01. 산소 잔량
// current(현재 산소량)에서 used(사용량)를 뺀 값을 반환하세요.
// 결과가 음수라면 0을 반환해야 합니다.
// 조건: if 표현식 또는 coerceAtLeast를 사용하세요.
// 예: remainingOxygen(100, 35) == 65, remainingOxygen(20, 30) == 0
fun remainingOxygen(current: Int, used: Int): Int {
    return 0 // TODO
}

fun main() {
    check(remainingOxygen(100, 35) == 65)
    check(remainingOxygen(20, 30) == 0)
    check(remainingOxygen(0, 0) == 0)
    println("C01 통과")
}
