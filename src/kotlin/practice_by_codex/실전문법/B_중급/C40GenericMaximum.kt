package practice_by_codex

// C40. 최댓값 탐색
// 비교 가능한 모든 타입의 목록에서 최댓값을 반환하세요.
// 빈 목록이면 null을 반환합니다.
// 조건: T에 Comparable<T> 제약을 선언하세요.
fun <T : Comparable<T>> genericMax(values: List<T>): T? {
    return null // TODO
}

fun main() {
    check(genericMax(listOf(3, 9, 1)) == 9)
    check(genericMax(listOf("Beta", "Alpha")) == "Beta")
    check(genericMax(emptyList<Int>()) == null)
    println("C40 통과")
}
