package pratice_by_agent

// B06. 구간 평균
// values에서 크기 size인 슬라이딩 윈도우 평균(Double) 리스트를 반환하세요.
// size <= 0 이거나 size > values.size 이면 빈 리스트를 반환하세요.
// 조건: windowed를 사용하세요.
fun windowAverages(values: List<Int>, size: Int): List<Double> {
    return emptyList() // TODO
}

fun main() {
    check(windowAverages(listOf(1, 2, 3, 4), 2) == listOf(1.5, 2.5, 3.5))
    check(windowAverages(listOf(1, 2), 3) == emptyList<Double>())
    check(windowAverages(listOf(10), 1) == listOf(10.0))
    println("B06 통과")
}
