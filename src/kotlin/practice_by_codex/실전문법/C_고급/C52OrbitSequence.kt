package practice_by_codex

// C52. 무한 궤도 생성
// start를 첫 값으로 하고 next 규칙으로 다음 값을 만드는 무한 Sequence를 반환하세요.
// 조건: generateSequence를 사용하세요. 소비자가 take 등으로 범위를 제한합니다.
fun orbitSequence(start: Int, next: (Int) -> Int): Sequence<Int> {
    return emptySequence() // TODO
}

fun main() {
    check(orbitSequence(1) { it * 2 }.take(6).toList() == listOf(1, 2, 4, 8, 16, 32))
    check(orbitSequence(10) { it + 3 }.take(3).toList() == listOf(10, 13, 16))
    println("C52 통과")
}
