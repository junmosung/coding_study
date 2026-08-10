package practice_by_agent

// B08. 누적 배터리
// 목표: 차감 후 0 클램프. final + trail(초기 포함).
// 문법: fold, runningFold
// 규칙: trail[0]==초기 charge.
// 예: 10,[3,20,1] → final 0, trail [10,7,0,0]
// 금지: 중간 과정 무시하고 final만
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

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
