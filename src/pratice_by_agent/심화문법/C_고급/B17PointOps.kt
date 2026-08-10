package pratice_by_agent

// B17. 좌표 연산자
// Point + Point, Point * Int 연산자를 구현하세요.
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(0, 0) // TODO
    }

    operator fun times(scale: Int): Point {
        return Point(0, 0) // TODO
    }
}

fun main() {
    check(Point(1, 2) + Point(3, 4) == Point(4, 6))
    check(Point(2, 3) * 2 == Point(4, 6))
    check(Point(0, 0) + Point(1, 1) * 3 == Point(3, 3))
    println("B17 통과")
}
