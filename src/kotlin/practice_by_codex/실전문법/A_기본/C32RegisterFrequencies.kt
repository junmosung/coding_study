package practice_by_codex

// C32. 주파수 일괄 등록
// first와 추가 주파수를 합쳐 중복 제거 후 오름차순으로 반환하세요.
// 조건: additional은 vararg로 받고 배열을 List로 변환하세요.
fun registerFrequencies(first: Int, vararg additional: Int): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(registerFrequencies(300) == listOf(300))
    check(registerFrequencies(300, 100, 300, 200) == listOf(100, 200, 300))

    val saved = intArrayOf(500, 400)
    check(registerFrequencies(300, *saved) == listOf(300, 400, 500))
    println("C32 통과")
}
