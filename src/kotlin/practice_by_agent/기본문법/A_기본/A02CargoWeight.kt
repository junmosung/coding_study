package practice_by_agent

// A02. 화물 무게
// 목표: kg Int 목록 합을 톤(Double)으로 변환. 1톤=1000kg.
// 문법: Int, Double, 명시적 변환
// 규칙: 빈 목록은 0.0. Int/Int 나눗셈으로 소수 유실 금지.
// 예: totalTons(listOf(500,500)) == 1.0
// 금지: 암묵적 확대 변환 가정
// 문서: docs/01_BASIC_SYNTAX.md

fun totalTons(weightsKg: List<Int>): Double {
    return 0.0 // TODO
}

fun main() {
    check(totalTons(listOf(500, 500)) == 1.0)
    check(totalTons(listOf(250)) == 0.25)
    check(totalTons(emptyList()) == 0.0)
    println("A02 통과")
}
