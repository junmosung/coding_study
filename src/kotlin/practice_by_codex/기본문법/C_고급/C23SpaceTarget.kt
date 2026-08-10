package practice_by_codex

// C23. 탐사 대상
// sealed class의 모든 하위 타입을 when으로 처리하세요.
// Planet -> "행성 {name}에 착륙합니다"
// Asteroid -> "소행성 #{id}는 착륙할 수 없습니다"
// Unknown -> "대상을 식별할 수 없습니다"
sealed class SpaceTarget {
    data class Planet(val name: String) : SpaceTarget()
    data class Asteroid(val id: Int) : SpaceTarget()
    object Unknown : SpaceTarget()
}

// 조건: when에서 else를 사용하지 마세요.
fun landingGuide(target: SpaceTarget): String {
    return "" // TODO
}

fun main() {
    check(landingGuide(SpaceTarget.Planet("Mars")) == "행성 Mars에 착륙합니다")
    check(landingGuide(SpaceTarget.Asteroid(42)) == "소행성 #42는 착륙할 수 없습니다")
    check(landingGuide(SpaceTarget.Unknown) == "대상을 식별할 수 없습니다")
    println("C23 통과")
}
