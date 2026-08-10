package practice_by_codex

// C27. 호출 부호 확장 함수
// 문자열 앞뒤 공백을 제거하고, 한 칸 이상의 공백을 하이픈 하나로 바꾼 뒤 대문자로 만드세요.
// 조건: String의 확장 함수로 작성하고 Regex("\\s+")를 활용하세요.
// 예: "  red   fox  ".toCallSign() == "RED-FOX"
fun String.toCallSign(): String {
    return "" // TODO
}

fun main() {
    check("  red   fox  ".toCallSign() == "RED-FOX")
    check("nova".toCallSign() == "NOVA")
    check("   ".toCallSign() == "")
    println("C27 통과")
}
