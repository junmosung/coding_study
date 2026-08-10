package pratice_by_agent

// A03. 드론 호출 부호
// name과 number를 받아 "NAME-NN" 형식으로 반환하세요.
// number는 항상 2자리(앞에 0 가능)로 패딩합니다.
// 조건: 표현식 본문(=)과 문자열 템플릿을 사용하세요.
// 예: droneCallSign("ALPHA", 3) == "ALPHA-03"
fun droneCallSign(name: String, number: Int): String = "" // TODO

fun main() {
    check(droneCallSign("ALPHA", 3) == "ALPHA-03")
    check(droneCallSign("BETA", 12) == "BETA-12")
    check(droneCallSign("Z", 0) == "Z-00")
    println("A03 통과")
}
