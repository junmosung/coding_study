package jvm_memory_learning.problems.m15

data class WorkerMemoryResult(val value: Int, val threadName: String)

// M15. worker 결과 publication
// work를 이름이 "memory-worker"인 새 thread에서 실행하고 join한 뒤 결과를 반환하세요.
// join 이전에 결과를 읽으면 안 됩니다.
fun runOnMemoryWorker(work: () -> Int): WorkerMemoryResult {
    return WorkerMemoryResult(0, "TODO") // TODO
}

fun main() {
    val mainThread = Thread.currentThread().name
    val result = runOnMemoryWorker { 21 * 2 }

    check(result.value == 42)
    check(result.threadName == "memory-worker")
    check(result.threadName != mainThread)
    println("M15 통과: main=$mainThread, worker=${result.threadName}")
}
