package pratice_by_agent

// B07. 구간 이동량
// 연속된 좌표 사이 차분 절대값 리스트를 반환하세요.
// 예: [1, 4, 2] -> [3, 2]
// 조건: zipWithNext를 사용하세요.
fun moveDeltas(points: List<Int>): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(moveDeltas(listOf(1, 4, 2)) == listOf(3, 2))
    check(moveDeltas(listOf(5)) == emptyList<Int>())
    check(moveDeltas(emptyList()) == emptyList<Int>())
    println("B07 통과")
}
