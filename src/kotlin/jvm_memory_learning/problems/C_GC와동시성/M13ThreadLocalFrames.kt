package jvm_memory_learning.problems.m13

// M13. 스레드별 local frame
// 각 chunk의 합은 해당 worker의 local 변수에서 계산하고,
// index가 정해진 results slot에 한 번만 기록하세요. 모든 worker를 join한 뒤 총합을 반환합니다.
fun parallelLocalSum(chunks: List<List<Int>>): Int {
    return 0 // TODO
}

fun main() {
    val chunks = listOf(
        (1..1_000).toList(),
        (1_001..2_000).toList(),
        (2_001..3_000).toList(),
    )
    check(parallelLocalSum(chunks) == (1..3_000).sum())
    check(parallelLocalSum(emptyList()) == 0)
    println("M13 통과")
}
