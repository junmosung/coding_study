package practice_by_codex

data class Vector2D(val x: Int, val y: Int) {
    // C45. 벡터 연산
    operator fun plus(other: Vector2D): Vector2D = Vector2D(0, 0) // TODO
    operator fun times(scale: Int): Vector2D = Vector2D(0, 0) // TODO
    operator fun get(index: Int): Int {
        // 0은 x, 1은 y. 그 외는 IndexOutOfBoundsException을 발생시키세요.
        return 0 // TODO
    }
}

fun main() {
    val vector = Vector2D(2, 3)
    check(vector + Vector2D(4, -1) == Vector2D(6, 2))
    check(vector * 3 == Vector2D(6, 9))
    check(vector[0] == 2 && vector[1] == 3)
    check(runCatching { vector[2] }.exceptionOrNull() is IndexOutOfBoundsException)
    println("C45 통과")
}
