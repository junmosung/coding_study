package practice_by_agent

// A15. 온도 요약
// 목표: min/max/average. 빈 목록은 null.
// 문법: data class, minOrNull, maxOrNull, average
// 규칙: 빈 목록 정책을 반환 타입에 반영.
// 예: listOf(10,20,30) → TempSummary(10,30,20.0)
// 금지: 빈 목록에서 min() 호출
// 문서: docs/04_TYPE_MODELING.md

data class TempSummary(val min: Int, val max: Int, val average: Double)

fun summarizeTemps(temps: List<Int>): TempSummary? {
    return null // TODO
}

fun main() {
    check(summarizeTemps(listOf(10, 20, 30)) == TempSummary(10, 30, 20.0))
    check(summarizeTemps(emptyList()) == null)
    println("A15 통과")
}
