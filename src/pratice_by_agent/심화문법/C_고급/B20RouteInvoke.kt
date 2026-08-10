package pratice_by_agent

// B20. 라우트 invoke
// Route("A","B")(distanceKm = 12) 호출로 Leg를 생성하세요.
data class Leg(val from: String, val to: String, val distanceKm: Int)

class Route(val from: String, val to: String) {
    operator fun invoke(distanceKm: Int): Leg {
        return Leg("", "", 0) // TODO
    }
}

fun main() {
    check(Route("A", "B")(distanceKm = 12) == Leg("A", "B", 12))
    check(Route("X", "Y")(3) == Leg("X", "Y", 3))
    println("B20 통과")
}
