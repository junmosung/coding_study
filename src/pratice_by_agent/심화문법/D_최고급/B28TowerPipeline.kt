package pratice_by_agent

data class DroneJobs(val name: String, val jobs: Int)

// B28. 관제 종합 파이프라인
// 각 문자열은 "드론:작업수" 형식입니다.
// 규칙:
// 1) 파싱 실패(콜론 없음/이름 빈값/Int 아님)는 버립니다.
// 2) 작업수 >= 3 만 남깁니다.
// 3) 작업수 내림차순, 동점이면 이름 오름차순 정렬
// 4) "#1 NAME (n jobs)" 형식으로 변환합니다.
// 조건: mapNotNull, filter, sortedWith, mapIndexed 사용. for문과 !! 금지.
fun towerRanking(rawResults: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val input = listOf(
        "Neo:5",
        "bad",
        "Trinity:5",
        "Morpheus:2",
        ":9",
        "Tank:x",
        "Mouse:3",
        "Apoc:1",
    )
    check(
        towerRanking(input) == listOf(
            "#1 Neo (5 jobs)",
            "#2 Trinity (5 jobs)",
            "#3 Mouse (3 jobs)",
        )
    )
    check(towerRanking(emptyList()) == emptyList<String>())
    println("B28 통과")
}
