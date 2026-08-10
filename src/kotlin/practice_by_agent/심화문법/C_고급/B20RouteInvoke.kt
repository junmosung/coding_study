package practice_by_agent

// B20. 라우트 invoke
// 목표: Route(from,to)(distanceKm) → Leg.
// 문법: operator invoke
// 규칙: 객체를 함수처럼 호출.
// 예: Route("A","B")(12)==Leg("A","B",12)
// 금지: invoke 없이 toLeg 메서드만
// 문서: docs/03_FUNCTIONS_LAMBDAS.md

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
