package practice_by_agent

// A01. 연료 잔량
// 목표: current에서 used를 뺀 잔량 반환. 음수면 0.
// 문법: val, if 표현식 또는 coerceAtLeast
// 규칙: 반환 타입 Int. 부족분은 0으로 클램프.
// 예: remainingFuel(80, 25) == 55 / remainingFuel(10, 40) == 0
// 금지: 불필요한 var, if (cond) return a else return b 남발
// 문서: docs/01_BASIC_SYNTAX.md

fun remainingFuel(current: Int, used: Int): Int {
    return 0 // TODO
}

fun main() {
    check(remainingFuel(80, 25) == 55)
    check(remainingFuel(10, 40) == 0)
    check(remainingFuel(0, 0) == 0)
    println("A01 통과")
}
