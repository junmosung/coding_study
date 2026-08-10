package practice_by_agent

// A08. 배터리 사이클
// 목표: rate씩 더해 target 이상 될 때까지 횟수. 이미 이상이면 0.
// 문법: while, 지역 var
// 규칙: rate는 양수. 무한루프 방지.
// 예: batteryCycles(10,30,7)==3
// 금지: 종료 조건 없는 while
// 문서: docs/01_BASIC_SYNTAX.md

fun batteryCycles(charge: Int, target: Int, rate: Int): Int {
    return 0 // TODO
}

fun main() {
    check(batteryCycles(10, 30, 7) == 3) // 10→17→24→31
    check(batteryCycles(30, 30, 5) == 0)
    check(batteryCycles(0, 10, 3) == 4) // 0→3→6→9→12
    println("A08 통과")
}
