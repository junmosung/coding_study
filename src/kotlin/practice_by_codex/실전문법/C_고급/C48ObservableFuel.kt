package practice_by_codex

import kotlin.properties.Delegates

class FuelTank(initialFuel: Int) {
    val changes = mutableListOf<Pair<Int, Int>>()

    // C48. 연료 변경 감시
    // 음수 변경은 거절하고, 허용된 변경만 old to new 형태로 changes에 기록하세요.
    // 조건: Delegates.vetoable을 사용하세요.
    var fuel: Int = initialFuel // TODO: 위임 프로퍼티로 변경
}

fun main() {
    val tank = FuelTank(100)
    tank.fuel = 70
    tank.fuel = -1
    tank.fuel = 50
    check(tank.fuel == 50)
    check(tank.changes == listOf(100 to 70, 70 to 50))
    println("C48 통과")
}
