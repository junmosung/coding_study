package jvm_memory_learning.problems.m14

import java.util.concurrent.atomic.AtomicInteger

// M14. 공유 Heap counter
// workerCount개의 thread가 increments번씩 증가한 정확한 결과를 반환하세요.
// AtomicInteger.incrementAndGet()과 join()을 사용합니다.
fun countAtomically(workerCount: Int, increments: Int): Int {
    return 0 // TODO
}

fun main() {
    check(countAtomically(workerCount = 4, increments = 50_000) == 200_000)
    check(countAtomically(workerCount = 0, increments = 100) == 0)
    println("M14 통과")
}
