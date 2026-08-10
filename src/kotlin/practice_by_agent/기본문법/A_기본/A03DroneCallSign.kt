package practice_by_agent

// A03. 드론 호출 부호
// 목표: name과 number로 NAME-NN 형식(2자리 zero-pad).
// 문법: 문자열 템플릿, 표현식 본문(=)
// 규칙: number는 항상 2자리.
// 예: droneCallSign("ALPHA", 3) == "ALPHA-03"
// 금지: 불필요한 StringBuilder
// 문서: docs/01_BASIC_SYNTAX.md

fun droneCallSign(name: String, number: Int): String = "" // TODO

fun main() {
    check(droneCallSign("ALPHA", 3) == "ALPHA-03")
    check(droneCallSign("BETA", 12) == "BETA-12")
    check(droneCallSign("Z", 0) == "Z-00")
    println("A03 통과")
}
