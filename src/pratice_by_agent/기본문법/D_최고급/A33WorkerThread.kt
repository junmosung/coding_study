package pratice_by_agent

// A33. 워커 스레드 (메인 vs 서브)
// runOnWorker는 서브 Thread에서 work를 실행하고, join으로 끝난 뒤 결과를 반환하세요.
// 또한 work가 실행된 스레드 이름이 현재(메인) 스레드 이름과 다르다는 것을 확인하세요.
// 조건: Thread { ... }.start() 와 join()을 사용하세요.
fun runOnWorker(work: () -> Int): Pair<Int, String> {
    // TODO: 서브 스레드에서 work 실행 → (결과, 워커 스레드 이름) 반환
    return 0 to ""
}

fun main() {
    val mainName = Thread.currentThread().name
    val (value, workerName) = runOnWorker {
        21 * 2
    }
    check(value == 42)
    check(workerName.isNotBlank())
    check(workerName != mainName)
    println("A33 통과 (main=$mainName, worker=$workerName)")
}
