package pratice_by_agent

// A21. 드론 상태
// Drone은 name과 초기 battery를 받습니다.
// fly(cost)는 cost가 0 이상이고 배터리가 충분할 때만 차감하고 true를 반환합니다.
// 실패하면 배터리를 바꾸지 않고 false를 반환합니다.
// 조건: battery는 외부에서 읽을 수 있지만 직접 변경할 수 없게 private set을 적용하세요.
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
