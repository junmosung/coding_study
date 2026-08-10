package practice_by_codex

// C51. 대용량 신호 처리
// 양수만 골라 convert한 뒤 앞의 limit개를 반환하세요.
// 조건: Sequence를 사용해 limit에 필요한 값까지만 convert가 호출되게 하세요.
fun processSignals(
    values: List<Int>,
    limit: Int,
    convert: (Int) -> Int,
): List<Int> {
    return emptyList() // TODO
}

fun main() {
    var conversions = 0
    val result = processSignals(listOf(-1, 1, 2, 3, 4), limit = 2) {
        conversions++
        it * 10
    }
    check(result == listOf(10, 20))
    check(conversions == 2)
    println("C51 통과")
}
