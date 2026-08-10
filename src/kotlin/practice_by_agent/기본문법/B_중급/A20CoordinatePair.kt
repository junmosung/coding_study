package practice_by_agent

// A20. 좌표 분해
// 목표: 'x,y' → Pair<Int,Int>?, sum은 구조 분해.
// 문법: Pair, 구조 분해, toIntOrNull
// 규칙: 형식 아니면 null.
// 예: parseCoordinate("3,5")==3 to 5
// 금지: !!
// 문서: docs/02_NULL_SAFETY.md

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
