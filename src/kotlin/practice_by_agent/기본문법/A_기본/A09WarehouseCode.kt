package practice_by_agent

// A09. 창고 코드
// 목표: N/S/E/W → NORTH/SOUTH/EAST/WEST (대소문자 무시), 그 외 UNKNOWN.
// 문법: Char, when, 입력 정규화
// 규칙: 먼저 uppercase 후 분기.
// 예: warehouseName('s')=="SOUTH"
// 금지: 대소문자별 when 중복 분기
// 문서: docs/01_BASIC_SYNTAX.md

fun warehouseName(code: Char): String {
    return "" // TODO
}

fun main() {
    check(warehouseName('N') == "NORTH")
    check(warehouseName('s') == "SOUTH")
    check(warehouseName('E') == "EAST")
    check(warehouseName('w') == "WEST")
    check(warehouseName('X') == "UNKNOWN")
    println("A09 통과")
}
