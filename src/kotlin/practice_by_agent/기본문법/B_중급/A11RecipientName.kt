package practice_by_agent

// A11. 수신자 이름
// 목표: null/공백 → GUEST, 아니면 trim+대문자.
// 문법: ?. , ?: , trim
// 규칙: !! 금지. null과 빈 문자열 구분.
// 예: normalizeRecipient("  neo ")=="NEO"
// 금지: !!
// 문서: docs/02_NULL_SAFETY.md

fun normalizeRecipient(name: String?): String {
    return "" // TODO
}

fun main() {
    check(normalizeRecipient("  neo ") == "NEO")
    check(normalizeRecipient(null) == "GUEST")
    check(normalizeRecipient("   ") == "GUEST")
    println("A11 통과")
}
