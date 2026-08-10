package practice_by_agent

// B27. 병렬 합산
// 목표: chunk 분할 병렬 합 == sum().
// 문법: Executor + 분할 병합
// 규칙: 결과 동일성.
// 예: 1..1000 parallelSum == sum()
// 금지: 결과 다른 레이스
// 문서: docs/10_JAVA_INTEROP.md

import java.util.concurrent.Executors

fun parallelSum(values: List<Int>, chunkSize: Int, poolSize: Int = 4): Int {
    return 0 // TODO
}

fun main() {
    val values = (1..1000).toList()
    check(parallelSum(values, chunkSize = 100) == values.sum())
    check(parallelSum(emptyList(), chunkSize = 10) == 0)
    check(parallelSum(listOf(7), chunkSize = 10) == 7)
    println("B27 통과")
}
