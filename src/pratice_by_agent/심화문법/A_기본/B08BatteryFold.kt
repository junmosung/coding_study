package pratice_by_agent

// B08. 누적 배터리
// 초기 charge에서 costs를 차례로 빼되 0 미만이면 0으로 클램프합니다.
// finalBattery: 최종 잔량만 (fold)
// batteryTrail: 매 단계 잔량 리스트, 초기값 포함 (runningFold)
// 예: charge=10, costs=[3, 20, 1] -> trail=[10, 7, 0, 0], final=0
fun finalBattery(charge: Int, costs: List<Int>): Int {
    return 0 // TODO
}

fun batteryTrail(charge: Int, costs: List<Int>): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(finalBattery(10, listOf(3, 20, 1)) == 0)
    check(batteryTrail(10, listOf(3, 20, 1)) == listOf(10, 7, 0, 0))
    check(batteryTrail(5, emptyList()) == listOf(5))
    println("B08 통과")
}
