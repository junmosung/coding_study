package pratice_by_agent

// A11. 수신자 이름 정규화
// name이 null이거나 공백뿐이면 "GUEST"를 반환하세요.
// 유효하면 앞뒤 공백 제거 후 대문자로 반환하세요.
// 조건: ?.와 ?:를 사용하고 !!는 금지합니다.
fun normalizeRecipient(name: String?): String {
    return "" // TODO
}

fun main() {
    check(normalizeRecipient("  neo ") == "NEO")
    check(normalizeRecipient(null) == "GUEST")
    check(normalizeRecipient("   ") == "GUEST")
    println("A11 통과")
}
