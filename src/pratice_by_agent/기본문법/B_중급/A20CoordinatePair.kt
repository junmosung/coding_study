package pratice_by_agent

// A20. 좌표 쌍
// "x,y" 형식 문자열을 Pair<Int, Int>로 파싱하세요. 실패하면 null.
// sumCoordinate는 Pair를 구조 분해해 x+y를 반환하세요.
fun parseCoordinate(raw: String): Pair<Int, Int>? {
    return null // TODO
}

fun sumCoordinate(point: Pair<Int, Int>): Int {
    return 0 // TODO
}

fun main() {
    check(parseCoordinate("3,5") == 3 to 5)
    check(parseCoordinate("a,1") == null)
    check(parseCoordinate("1") == null)
    check(sumCoordinate(2 to 7) == 9)
    println("A20 통과")
}
