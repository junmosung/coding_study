package pratice_by_codex

// C09. 배터리 충전 횟수
// 배터리는 충전 한 번마다 7 증가합니다.
// current가 target 이상이 되기까지 필요한 충전 횟수를 반환하세요.
// 이미 목표 이상이면 0입니다.
// 조건: while문을 사용하세요.
fun requiredCharges(current: Int, target: Int): Int {
    return 0 // TODO
}

fun main() {
    check(requiredCharges(10, 30) == 3)
    check(requiredCharges(30, 30) == 0)
    check(requiredCharges(31, 30) == 0)
    check(requiredCharges(0, 8) == 2)
    println("C09 통과")
}
