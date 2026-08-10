package practice_by_codex

data class ExplorationScore(val name: String, val score: Int)

// C30. 탐사 결과 파이프라인
// 각 문자열은 "대원명:점수" 형식입니다.
// 다음 규칙을 모두 적용한 순위 문자열 목록을 반환하세요.
// 1) 콜론이 없거나, 이름이 비었거나, 점수가 Int가 아니면 버립니다.
// 2) 60점 이상만 남깁니다.
// 3) 점수 내림차순, 동점이면 이름 오름차순으로 정렬합니다.
// 4) "1위 이름(점수)" 형식으로 변환합니다.
// 조건: mapNotNull, filter, sortedWith, mapIndexed를 모두 사용하고 for문과 !!는 금지합니다.
fun explorationRanking(rawResults: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val input = listOf(
        "Neo:90",
        "bad",
        "Trinity:90",
        "Morpheus:55",
        ":100",
        "Tank:not-number",
        "Mouse:70",
    )
    check(
        explorationRanking(input) == listOf(
            "1위 Neo(90)",
            "2위 Trinity(90)",
            "3위 Mouse(70)",
        )
    )
    check(explorationRanking(emptyList()) == emptyList<String>())
    println("C30 통과")
}
