package practice_by_agent

// B17. 좌표 연산
// 목표: Point+Point, Point*Int.
// 문법: operator plus, times
// 규칙: 연산자 우선순위 의식.
// 예: Point(1,2)+Point(3,4)==Point(4,6)
// 금지: plus 대신 add 메서드만
// 문서: docs/03_FUNCTIONS_LAMBDAS.md

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
