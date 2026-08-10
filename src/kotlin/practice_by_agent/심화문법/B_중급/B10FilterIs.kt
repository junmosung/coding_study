package practice_by_agent

// B10. 타입 재화
// 목표: List<Any>에서 T만.
// 문법: inline + reified
// 규칙: filterIsInstance 호출 금지.
// 예: filterIs<String>([1,"a"])==["a"]
// 금지: Class<T> 인자로 우회만
// 문서: docs/06_GENERICS_VARIANCE.md

inline fun <reified T> filterIs(list: List<Any>): List<T> {
    return emptyList() // TODO
}

fun main() {
    val mixed: List<Any> = listOf(1, "a", 2, "b", 3.0)
    check(filterIs<String>(mixed) == listOf("a", "b"))
    check(filterIs<Int>(mixed) == listOf(1, 2))
    println("B10 통과")
}
