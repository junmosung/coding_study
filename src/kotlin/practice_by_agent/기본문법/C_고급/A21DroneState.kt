package practice_by_agent

// A21. 드론 상태
// 목표: fly(cost): cost>=0 이고 배터리 충분할 때만 차감.
// 문법: class, private set
// 규칙: energy 외부 직접 변경 불가.
// 예: 10에서 fly(4)→true energy6, fly(7)→false
// 금지: var energy 공개 set
// 문서: docs/04_TYPE_MODELING.md

class Drone(val name: String, battery: Int) {
    var battery: Int = battery
        private set

    fun fly(cost: Int): Boolean {
        return false // TODO
    }
}

fun main() {
    val drone = Drone("D1", 10)
    check(drone.fly(4))
    check(drone.battery == 6)
    check(!drone.fly(7))
    check(drone.battery == 6)
    check(!drone.fly(-1))
    println("A21 통과")
}
