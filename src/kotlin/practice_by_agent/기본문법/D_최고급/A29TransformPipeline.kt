package practice_by_agent

// A29. 변환기
// 목표: transform 적용. map 버전 + for 버전.
// 문법: 함수 타입 (Int)->Int, 고차 함수
// 규칙: 원본 리스트 불변.
// 예: map {it*10} → [10,20,30]
// 금지: 전역 변환 함수만 사용
// 문서: docs/03_FUNCTIONS_LAMBDAS.md

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
