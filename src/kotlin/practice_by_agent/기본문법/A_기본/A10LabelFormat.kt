package practice_by_agent

// A10. 라벨 포맷
// 목표: prefix-id. 기본 prefix=PKG, upper=true.
// 문법: 기본 인자, 이름 있는 인자
// 규칙: upper면 id 대문자.
// 예: formatLabel("ab12")=="PKG-AB12"
// 금지: 오버로드로 기본값 흉내
// 문서: docs/03_FUNCTIONS_LAMBDAS.md

fun formatLabel(id: String, prefix: String = "PKG", upper: Boolean = true): String {
    return "" // TODO
}

fun main() {
    check(formatLabel("ab12") == "PKG-AB12")
    check(formatLabel("ab12", upper = false) == "PKG-ab12")
    check(formatLabel("z9", prefix = "BOX") == "BOX-Z9")
    println("A10 통과")
}
