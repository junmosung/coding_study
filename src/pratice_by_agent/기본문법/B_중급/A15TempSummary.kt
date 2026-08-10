package pratice_by_agent

data class TempSummary(val min: Int, val max: Int, val average: Double)

// A15. 온도 요약
// 온도 목록의 최저, 최고, 평균을 TempSummary로 반환하세요.
// 빈 목록이면 null을 반환하세요.
// 조건: minOrNull, maxOrNull, average를 활용하세요.
fun summarizeTemps(temps: List<Int>): TempSummary? {
    return null // TODO
}

fun main() {
    check(summarizeTemps(listOf(10, 20, 30)) == TempSummary(10, 30, 20.0))
    check(summarizeTemps(emptyList()) == null)
    println("A15 통과")
}
