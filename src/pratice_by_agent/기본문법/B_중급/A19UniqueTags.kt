package pratice_by_agent

// A19. 태그 유일화
// 입력 순서를 유지한 채 중복을 제거한 리스트를 반환하세요.
// 조건: Set(예: LinkedHashSet) 또는 동등한 표준 라이브러리 연산을 사용하세요.
fun uniqueTags(tags: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    check(uniqueTags(listOf("fast", "cold", "fast", "fragile")) == listOf("fast", "cold", "fragile"))
    check(uniqueTags(emptyList()) == emptyList<String>())
    println("A19 통과")
}
