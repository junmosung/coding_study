package pratice_by_codex

// C16. 자원 재고 합치기
// first와 second를 합친 새 Map을 반환하세요.
// 같은 자원 키가 있으면 수량을 더하고, 원본 Map은 변경하지 않습니다.
// 조건: mutableMapOf 또는 toMutableMap과 Map 순회를 사용하세요.
fun mergeInventory(first: Map<String, Int>, second: Map<String, Int>): Map<String, Int> {
    return emptyMap() // TODO
}

fun main() {
    val first = mapOf("water" to 3, "food" to 2)
    val second = mapOf("water" to 4, "fuel" to 5)
    check(mergeInventory(first, second) == mapOf("water" to 7, "food" to 2, "fuel" to 5))
    check(first == mapOf("water" to 3, "food" to 2))
    check(second == mapOf("water" to 4, "fuel" to 5))
    println("C16 통과")
}
