package practice_by_codex

class LazyPlanetMap(private val loader: () -> Map<String, Int>) {
    // C37. 지연 초기화 지도
    // loader는 planets가 처음 사용될 때 한 번만 호출되어야 합니다.
    val planets: Map<String, Int> = emptyMap() // TODO: by lazy 적용
}

fun main() {
    var loads = 0
    val map = LazyPlanetMap {
        loads++
        mapOf("Mars" to 4, "Earth" to 3)
    }
    check(loads == 0)
    check(map.planets["Mars"] == 4)
    check(map.planets["Earth"] == 3)
    check(loads == 1)
    println("C37 통과")
}
