package pratice_by_codex

// C10. 선장의 별명
// nickname이 null이거나 공백뿐이면 ANONYMOUS를 반환하세요.
// 유효한 값이면 앞뒤 공백을 제거한 뒤 대문자로 반환하세요.
// 조건: ?.와 ?:를 사용하고 !!는 사용하지 마세요.
fun normalizeNickname(nickname: String?): String {
    return "" // TODO
}

fun main() {
    check(normalizeNickname("  nova ") == "NOVA")
    check(normalizeNickname(null) == "ANONYMOUS")
    check(normalizeNickname("   ") == "ANONYMOUS")
    println("C10 통과")
}
