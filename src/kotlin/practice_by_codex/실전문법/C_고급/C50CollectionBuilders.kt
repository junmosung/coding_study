package practice_by_codex

data class Supply(val name: String, val amount: Int)

// C50. 컬렉션 빌더
// amount가 양수인 보급품만 사용합니다.
// List에는 이름을 입력 순서대로, Map에는 이름별 수량 합계를 담아 Pair로 반환하세요.
// 조건: buildList와 buildMap을 각각 사용하세요.
fun buildSupplyCollections(supplies: List<Supply>): Pair<List<String>, Map<String, Int>> {
    return emptyList<String>() to emptyMap() // TODO
}

fun main() {
    val supplies = listOf(
        Supply("water", 2), Supply("food", 0), Supply("water", 3), Supply("fuel", 1)
    )
    val (names, totals) = buildSupplyCollections(supplies)
    check(names == listOf("water", "water", "fuel"))
    check(totals == mapOf("water" to 5, "fuel" to 1))
    println("C50 통과")
}
