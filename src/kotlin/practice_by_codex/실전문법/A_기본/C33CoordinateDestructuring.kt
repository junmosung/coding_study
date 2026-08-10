package practice_by_codex

import kotlin.math.sqrt

data class Coordinate3D(val x: Int, val y: Int, val z: Int)

// C33. 좌표 구조 분해
// 좌표를 구조 분해하고 원점까지의 유클리드 거리를 계산하세요.
fun distanceFromOrigin(coordinate: Coordinate3D): Double {
    return 0.0 // TODO
}

// "(x, y, z)" 형식으로 반환하세요. 구조 분해 선언을 사용합니다.
fun formatCoordinate(coordinate: Coordinate3D): String {
    return "" // TODO
}

fun main() {
    check(distanceFromOrigin(Coordinate3D(3, 4, 0)) == 5.0)
    check(kotlin.math.abs(distanceFromOrigin(Coordinate3D(1, 2, 2)) - 3.0) < 0.000001)
    check(formatCoordinate(Coordinate3D(1, -2, 3)) == "(1, -2, 3)")
    println("C33 통과")
}
