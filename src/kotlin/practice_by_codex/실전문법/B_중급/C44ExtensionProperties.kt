package practice_by_codex

// C44. 거리 확장 프로퍼티
// 정수 km를 meter 단위로 변환하는 계산형 확장 프로퍼티를 완성하세요.
val Int.kilometersInMeters: Int
    get() = 0 // TODO

data class MapPoint(val x: Int, val y: Int)

val MapPoint.isOrigin: Boolean
    get() = false // TODO: x와 y가 모두 0인지 확인

fun main() {
    check(3.kilometersInMeters == 3_000)
    check(MapPoint(0, 0).isOrigin)
    check(!MapPoint(0, 1).isOrigin)
    println("C44 통과")
}
