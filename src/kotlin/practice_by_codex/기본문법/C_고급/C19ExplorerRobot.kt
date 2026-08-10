package practice_by_codex

// C19. 탐사 로봇
// Robot은 name과 초기 energy를 받습니다.
// move(cost)는 cost가 0 이상이고 에너지가 충분할 때만 에너지를 차감하고 true를 반환합니다.
// 실패하면 에너지를 바꾸지 않고 false를 반환합니다.
// 조건: energy는 외부에서 읽을 수 있지만 직접 변경할 수 없게 private set을 적용하세요.
class ExplorerRobot(val name: String, energy: Int) {
    var energy: Int = energy
        private set

    fun move(cost: Int): Boolean {
        return false // TODO
    }
}

fun main() {
    val robot = ExplorerRobot("R2", 10)
    check(robot.move(4))
    check(robot.energy == 6)
    check(!robot.move(7))
    check(robot.energy == 6)
    check(!robot.move(-1))
    println("C19 통과")
}
