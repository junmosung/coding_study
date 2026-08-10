package practice_by_agent

// A06. 이륙 가능
// 목표: battery>=40 && wind<=12 && cargoLocked.
// 문법: Boolean, &&
// 규칙: 조건식 자체를 반환.
// 예: canLaunch(40,12,true)==true
// 금지: if (c) true else false
// 문서: docs/01_BASIC_SYNTAX.md

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
