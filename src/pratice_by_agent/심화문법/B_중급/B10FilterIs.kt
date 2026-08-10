package pratice_by_agent

// B10. 타입 재화 필터
// list에서 T 타입만 남겨 반환하세요.
// 조건: inline + reified로 직접 구현하세요. (filterIsInstance 호출 금지)
inline fun <reified T> filterIs(list: List<Any>): List<T> {
    return emptyList() // TODO
}

fun main() {
    val mixed: List<Any> = listOf(1, "a", 2, "b", 3.0)
    check(filterIs<String>(mixed) == listOf("a", "b"))
    check(filterIs<Int>(mixed) == listOf(1, 2))
    println("B10 통과")
}
