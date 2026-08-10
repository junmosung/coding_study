package pratice_by_agent

// A06. 이륙 가능 여부
// battery >= 40 이고 wind <= 12 이고 cargoLocked == true 일 때만 true를 반환하세요.
// 조건: if (cond) true else false 대신 조건식 자체를 반환하세요.
fun canLaunch(battery: Int, wind: Int, cargoLocked: Boolean): Boolean {
    return false // TODO
}

fun main() {
    check(canLaunch(40, 12, true))
    check(!canLaunch(39, 12, true))
    check(!canLaunch(50, 13, true))
    check(!canLaunch(80, 5, false))
    println("A06 통과")
}
