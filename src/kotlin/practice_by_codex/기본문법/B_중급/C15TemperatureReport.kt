package practice_by_codex

data class TemperatureReport(val minimum: Int, val maximum: Int, val average: Double)

// C15. 온도 보고서
// 온도 목록의 최저, 최고, 평균을 TemperatureReport로 반환하세요.
// 빈 목록은 계산할 수 없으므로 null을 반환합니다.
// 조건: minOrNull, maxOrNull, average를 사용하세요.
fun temperatureReport(values: List<Int>): TemperatureReport? {
    return null // TODO
}

fun main() {
    check(temperatureReport(listOf(-10, 20, 5)) == TemperatureReport(-10, 20, 5.0))
    check(temperatureReport(listOf(3, 4)) == TemperatureReport(3, 4, 3.5))
    check(temperatureReport(emptyList()) == null)
    println("C15 통과")
}
