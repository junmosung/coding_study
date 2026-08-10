package pratice_by_agent

// A29. 변환기
// values의 모든 값을 transform으로 변환한 새 리스트를 반환하세요.
// 조건: 첫 함수는 map, 두 번째 함수는 for문을 사용해 각각 구현하세요.
fun transformWithMap(values: List<Int>, transform: (Int) -> Int): List<Int> {
    return emptyList() // TODO
}

fun transformWithLoop(values: List<Int>, transform: (Int) -> Int): List<Int> {
    return emptyList() // TODO
}

fun main() {
    val values = listOf(1, 2, 3)
    check(transformWithMap(values) { it * 10 } == listOf(10, 20, 30))
    check(transformWithLoop(values) { it + 1 } == listOf(2, 3, 4))
    check(values == listOf(1, 2, 3))
    println("A29 통과")
}
