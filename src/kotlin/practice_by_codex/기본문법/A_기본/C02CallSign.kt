package practice_by_codex

// C02. 탐사대 호출 부호
// name과 number를 "이름-번호" 형식의 문자열로 만드세요.
// 조건: 문자열 템플릿과 표현식 본문(=)을 사용하세요.
// 예: callSign("NOVA", 7) == "NOVA-7"
fun callSign(name: String, number: Int): String = "" // TODO

fun main() {
    check(callSign("NOVA", 7) == "NOVA-7")
    check(callSign("ORBIT", 12) == "ORBIT-12")
    println("C02 통과")
}
