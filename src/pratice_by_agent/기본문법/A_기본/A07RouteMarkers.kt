package pratice_by_agent

// A07. 경로 마커
// 0부터 limit 미만까지 step 간격의 숫자를 "-"로 이은 문자열을 만드세요.
// 조건: 범위와 joinToString을 사용하세요. (수동 문자열 누적 지양)
// 예: routeMarkers(10, 3) == "0-3-6-9"
fun routeMarkers(limit: Int, step: Int): String {
    return "" // TODO
}

fun main() {
    check(routeMarkers(10, 3) == "0-3-6-9")
    check(routeMarkers(5, 2) == "0-2-4")
    check(routeMarkers(1, 1) == "0")
    println("A07 통과")
}
