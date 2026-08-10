package pratice_by_codex

// C13. 유효한 대원 ID
// 양수 ID만 남기고 중복을 제거한 뒤 오름차순으로 반환하세요.
// 조건: filter, distinct, sorted를 체이닝하고 for문은 사용하지 마세요.
fun validCrewIds(ids: List<Int>): List<Int> {
    return emptyList() // TODO
}

fun main() {
    check(validCrewIds(listOf(3, -1, 2, 3, 0)) == listOf(2, 3))
    check(validCrewIds(emptyList()) == emptyList<Int>())
    check(validCrewIds(listOf(5, 5, 5)) == listOf(5))
    println("C13 통과")
}
