package pratice_by_agent

// A10. 라벨 포맷
// prefix와 id를 "PREFIX-ID" 형식으로 합치세요.
// upper가 true면 id를 대문자로, false면 입력 그대로 둡니다.
// 조건: 기본 인자 prefix="PKG", upper=true 를 선언하고 이름 있는 인자로 호출을 검증하세요.
fun formatLabel(id: String, prefix: String = "PKG", upper: Boolean = true): String {
    return "" // TODO
}

fun main() {
    check(formatLabel("ab12") == "PKG-AB12")
    check(formatLabel("ab12", upper = false) == "PKG-ab12")
    check(formatLabel("z9", prefix = "BOX") == "BOX-Z9")
    println("A10 통과")
}
