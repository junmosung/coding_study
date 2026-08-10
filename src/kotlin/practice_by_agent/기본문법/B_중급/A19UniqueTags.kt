package practice_by_agent

// A19. 태그 유일화
// 목표: 입력 순서 유지하며 중복 제거.
// 문법: Set / LinkedHashSet / distinct
// 규칙: 첫 등장 순서 보존.
// 예: ["fast","cold","fast"] → ["fast","cold"]
// 금지: 정렬로 중복 제거
// 문서: docs/05_COLLECTIONS_SEQUENCES.md

fun uniqueTags(tags: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    check(uniqueTags(listOf("fast", "cold", "fast", "fragile")) == listOf("fast", "cold", "fragile"))
    check(uniqueTags(emptyList()) == emptyList<String>())
    println("A19 통과")
}
