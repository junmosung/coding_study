package pratice_by_agent

// A08. 배터리 충전 사이클
// 현재 charge에서 한 번에 rate만큼 더해 target 이상이 될 때까지의 횟수를 구하세요.
// 이미 target 이상이면 0을 반환합니다.
// 조건: while과 지역 var를 사용하세요. rate는 항상 양수라고 가정합니다.
fun batteryCycles(charge: Int, target: Int, rate: Int): Int {
    return 0 // TODO
}

fun main() {
    check(batteryCycles(10, 30, 7) == 3) // 10→17→24→31
    check(batteryCycles(30, 30, 5) == 0)
    check(batteryCycles(0, 10, 3) == 4) // 0→3→6→9→12
    println("A08 통과")
}
