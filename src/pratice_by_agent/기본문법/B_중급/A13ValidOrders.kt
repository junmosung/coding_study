package pratice_by_agent

// A13. 유효 주문 ID
// 양수 ID만 남기고 중복을 제거한 뒤 오름차순으로 반환하세요.
// 조건: filter, distinct, sorted를 사용하세요. 원본 리스트는 바꾸지 마세요.
fun validOrderIds(ids: List<Int>): List<Int> {
    return emptyList() // TODO
}

fun main() {
    val input = listOf(3, -1, 2, 3, 0, 2)
    check(validOrderIds(input) == listOf(2, 3))
    check(input == listOf(3, -1, 2, 3, 0, 2))
    check(validOrderIds(emptyList()) == emptyList<Int>())
    println("A13 통과")
}
