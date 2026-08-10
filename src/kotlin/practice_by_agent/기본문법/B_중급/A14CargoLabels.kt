package practice_by_agent

// A14. 화물 라벨
// 목표: 대문자화 후 '1. NAME' 형식.
// 문법: mapIndexed
// 규칙: 표시 인덱스는 1부터.
// 예: ["water","food"] → ["1. WATER","2. FOOD"]
// 금지: for+mutableList 필수화
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun cargoLabels(names: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    check(cargoLabels(listOf("water", "food")) == listOf("1. WATER", "2. FOOD"))
    check(cargoLabels(emptyList()) == emptyList<String>())
    println("A14 통과")
}
