package practice_by_agent

// A23. 드론 등급
// 목표: SCOUT1/HAULER2/COMMAND3, canAccess(required).
// 문법: enum class
// 규칙: level >= required 이면 true.
// 예: HAULER.canAccess(2)==true, canAccess(3)==false
// 금지: 문자열 상수만 나열
// 문서: docs/04_TYPE_MODELING.md

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
