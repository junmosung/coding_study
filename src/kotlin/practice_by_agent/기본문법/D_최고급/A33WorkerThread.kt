package practice_by_agent

// A33. 워커 스레드
// 목표: 서브 Thread에서 work 실행 후 join, (결과,워커이름) 반환.
// 문법: Thread, join
// 규칙: 워커 이름 ≠ 메인 이름.
// 예: runOnWorker{21*2} 첫 값 42
// 금지: join 없이 결과 읽기
// 문서: docs/10_JAVA_INTEROP.md

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
