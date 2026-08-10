package practice_by_codex

fun interface RouteStrategy {
    fun select(routes: List<String>): String?
}

// C56. 단일 메서드 전략
// strategy로 경로를 선택하되 routes가 비었으면 전략을 호출하지 않고 null을 반환하세요.
fun chooseRoute(routes: List<String>, strategy: RouteStrategy): String? {
    return null // TODO
}

fun main() {
    val shortest = RouteStrategy { routes -> routes.minByOrNull { it.length } }
    check(chooseRoute(listOf("MARS", "MOON", "IO"), shortest) == "IO")

    var called = false
    check(chooseRoute(emptyList(), RouteStrategy { called = true; null }) == null)
    check(!called)
    println("C56 통과")
}
