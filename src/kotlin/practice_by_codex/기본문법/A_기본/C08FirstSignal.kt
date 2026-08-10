package practice_by_codex

// C08. 첫 번째 유효 신호
// signals에서 처음 등장하는 양수의 인덱스를 반환하세요.
// 양수가 없다면 -1을 반환합니다.
// 조건: for문, indices 또는 withIndex(), break/즉시 반환을 사용하세요.
fun firstPositiveIndex(signals: List<Int>): Int {
    return -1 // TODO
}

fun main() {
    check(firstPositiveIndex(listOf(-3, 0, 8, 2)) == 2)
    check(firstPositiveIndex(listOf(1, 2)) == 0)
    check(firstPositiveIndex(listOf(-1, 0)) == -1)
    check(firstPositiveIndex(emptyList()) == -1)
    println("C08 통과")
}
