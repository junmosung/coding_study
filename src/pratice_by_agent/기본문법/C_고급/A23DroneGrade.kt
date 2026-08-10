package pratice_by_agent

// A23. 드론 등급
// SCOUT(권한 1), HAULER(권한 2), COMMAND(권한 3) enum입니다.
// canAccess(required)는 자신의 level이 required 이상이면 true입니다.
enum class DroneGrade(val level: Int) {
    SCOUT(1),
    HAULER(2),
    COMMAND(3);

    fun canAccess(required: Int): Boolean {
        return false // TODO
    }
}

fun main() {
    check(DroneGrade.SCOUT.level == 1)
    check(DroneGrade.HAULER.canAccess(2))
    check(!DroneGrade.HAULER.canAccess(3))
    check(DroneGrade.COMMAND.canAccess(3))
    println("A23 통과")
}
