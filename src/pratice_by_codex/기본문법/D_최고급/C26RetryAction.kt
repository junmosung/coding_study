package pratice_by_codex

// C26. 안전한 재시도
// action을 성공(true)할 때까지 최대 maxAttempts번 실행하세요.
// 성공하면 1부터 시작하는 실제 시도 횟수, 전부 실패하면 -1을 반환합니다.
// maxAttempts가 0 이하이면 action을 실행하지 않고 -1을 반환합니다.
fun retryAction(maxAttempts: Int, action: () -> Boolean): Int {
    return -1 // TODO
}

fun main() {
    var attempts = 0
    check(retryAction(5) { ++attempts == 3 } == 3)
    check(attempts == 3)

    var neverRun = false
    check(retryAction(0) { neverRun = true; true } == -1)
    check(!neverRun)
    check(retryAction(2) { false } == -1)
    println("C26 통과")
}
