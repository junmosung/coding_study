package practice_by_codex

// C42. 타입별 신호 추출
// 혼합 목록에서 T 타입인 값만 순서를 유지해 반환하세요.
// 조건: inline과 reified를 사용하고 filterIsInstance를 직접 호출하지 마세요.
inline fun <reified T> Iterable<*>.signalsOfType(): List<T> {
    return emptyList() // TODO
}

fun main() {
    val mixed = listOf(1, "alpha", 2L, "beta", null)
    check(mixed.signalsOfType<String>() == listOf("alpha", "beta"))
    check(mixed.signalsOfType<Int>() == listOf(1))
    println("C42 통과")
}
