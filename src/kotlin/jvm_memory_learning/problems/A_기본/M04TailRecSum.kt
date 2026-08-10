package jvm_memory_learning.problems.m04

// M04. tail recursion
// 1..n의 합을 구하세요. 반복문 없이 tailrec를 유지합니다.
tailrec fun sumTo(n: Int, accumulator: Long = 0): Long {
    if (n <= 0) return -1 // TODO: accumulator를 반환
    return sumTo(n - 1, accumulator) // TODO: 현재 n을 누적
}

fun main() {
    check(sumTo(0) == 0L)
    check(sumTo(5) == 15L)
    check(sumTo(100_000) == 5_000_050_000L)
    println("M04 통과")
}
