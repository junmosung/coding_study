package practice_by_agent

// A16. 재고 합치기
// 목표: 두 Map 수량 합산. 원본 변경 금지.
// 문법: Map, MutableMap
// 규칙: 내부 mutable OK, 반환은 읽기 전용.
// 예: bolt 2+nut 1 과 nut 3 → nut 4
// 금지: 입력 Map 직접 put
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

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
