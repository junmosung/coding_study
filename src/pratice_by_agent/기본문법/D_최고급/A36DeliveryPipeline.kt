package pratice_by_agent

data class PilotScore(val name: String, val score: Int)

// A36. 배송 결과 파이프라인
// 각 문자열은 "드론명:점수" 형식입니다.
// 규칙:
// 1) 콜론이 없거나, 이름이 비었거나, 점수가 Int가 아니면 버립니다.
// 2) 70점 이상만 남깁니다.
// 3) 점수 내림차순, 동점이면 이름 오름차순으로 정렬합니다.
// 4) "1위 이름(점수)" 형식으로 변환합니다.
// 조건: mapNotNull, filter, sortedWith, mapIndexed를 사용하고 for문과 !!는 금지합니다.
fun deliveryRanking(rawResults: List<String>): List<String> {
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
        "Apoc:69",
    )
    check(
        deliveryRanking(input) == listOf(
            "1위 Neo(90)",
            "2위 Trinity(90)",
            "3위 Mouse(70)",
        )
    )
    check(deliveryRanking(emptyList()) == emptyList<String>())
    println("A36 통과")
}
