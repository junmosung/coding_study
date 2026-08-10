package pratice_by_agent

// A16. 재고 합치기
// 두 재고 Map을 합치며 같은 키는 수량을 더하세요.
// 원본 Map은 변경하지 마세요. 반환 타입은 읽기 전용 Map입니다.
fun mergeStock(a: Map<String, Int>, b: Map<String, Int>): Map<String, Int> {
    return emptyMap() // TODO
}

fun main() {
    val left = mapOf("bolt" to 2, "nut" to 1)
    val right = mapOf("nut" to 3, "washer" to 4)
    check(mergeStock(left, right) == mapOf("bolt" to 2, "nut" to 4, "washer" to 4))
    check(left == mapOf("bolt" to 2, "nut" to 1))
    check(right == mapOf("nut" to 3, "washer" to 4))
    println("A16 통과")
}
