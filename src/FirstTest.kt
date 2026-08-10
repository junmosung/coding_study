// 한 줄의 숫자들을 담는 객체
data class NumberLine(val numbers: List<Long>) {
    val positiveSum: Long get() = numbers.filter { it > 0 }.sum()   // 양수 합계

    // 문자열 한 줄 → NumberLine 객체로 파싱하는 팩토리
    companion object {
        fun parse(line: String): NumberLine =
            NumberLine(
                line.trim()
                    .split(Regex("\\s+"))
                    .map(String::toLong)
            )
    }
}

fun main() {
    generateSequence(::readlnOrNull)             // EOF까지 한 줄씩 (null이면 자동 종료)
        .filter { it.isNotBlank() }              // 빈 줄 건너뛰기
        .map(NumberLine::parse)                  // 각 줄 → NumberLine 객체로 파싱
        .forEach { line ->
            println("sum=${line.positiveSum}")   // 객체가 합계를 계산
        }
}
