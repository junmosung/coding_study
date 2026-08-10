package practice_by_agent

// A07. 경로 마커
// 목표: 0 until limit step step 를 '-'로 연결.
// 문법: 범위, step, joinToString
// 규칙: limit 미만. step>0 가정.
// 예: routeMarkers(10,3)=="0-3-6-9"
// 금지: 수동 문자열 += 누적
// 문서: docs/01_BASIC_SYNTAX.md

fun routeMarkers(limit: Int, step: Int): String {
    return "" // TODO
}

fun main() {
    check(routeMarkers(10, 3) == "0-3-6-9")
    check(routeMarkers(5, 2) == "0-2-4")
    check(routeMarkers(1, 1) == "0")
    println("A07 통과")
}
