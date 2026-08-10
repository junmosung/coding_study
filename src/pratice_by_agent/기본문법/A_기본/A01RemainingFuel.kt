package pratice_by_agent

// A01. 연료 잔량
// current에서 used를 뺀 값을 반환하세요.
// 결과가 음수라면 0을 반환해야 합니다.
// 조건: if 표현식 또는 coerceAtLeast를 사용하세요.
// 예: remainingFuel(80, 25) == 55, remainingFuel(10, 40) == 0
fun remainingFuel(current: Int, used: Int): Int {
    return 0 // TODO
}

fun main() {
    check(remainingFuel(80, 25) == 55)
    check(remainingFuel(10, 40) == 0)
    check(remainingFuel(0, 0) == 0)
    println("A01 통과")
}
