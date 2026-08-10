package pratice_by_agent

// A02. 화물 무게 합
// kg 단위 Int 목록의 합을 톤(Double)으로 반환하세요. (1톤 = 1000kg)
// 조건: Int 나눗셈으로 소수부가 사라지지 않게 하세요.
// 예: totalTons(listOf(500, 500)) == 1.0, totalTons(emptyList()) == 0.0
fun totalTons(weightsKg: List<Int>): Double {
    return 0.0 // TODO
}

fun main() {
    check(totalTons(listOf(500, 500)) == 1.0)
    check(totalTons(listOf(250)) == 0.25)
    check(totalTons(emptyList()) == 0.0)
    println("A02 통과")
}
