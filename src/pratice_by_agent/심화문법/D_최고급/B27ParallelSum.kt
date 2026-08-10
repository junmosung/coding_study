package pratice_by_agent

import java.util.concurrent.Executors

// B27. 병렬 구간 합산
// values를 chunkSize 크기로 나눠 스레드 풀에서 부분 합을 구한 뒤 총합을 반환하세요.
// 단일 스레드 sum()과 결과가 같아야 합니다.
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
