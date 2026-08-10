package pratice_by_agent

// A09. 창고 코드
// 단일 Char 코드를 방향 이름으로 바꾸세요. 대소문자는 구분하지 않습니다.
// N→NORTH, S→SOUTH, E→EAST, W→WEST, 그 외→UNKNOWN
// 조건: when을 사용하고 입력을 먼저 정규화하세요.
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
