package practice_by_codex

// C57. 인라인 실행 제어
// action 결과를 audit과 onComplete에 순서대로 전달하고 결과를 반환하세요.
// audit은 Runnable 안에서 호출해야 하므로 crossinline을 유지합니다.
// onComplete는 지역 변수로 저장해야 하므로 noinline을 유지합니다.
inline fun <T> executeWithCallbacks(
    action: () -> T,
    crossinline audit: (T) -> Unit,
    noinline onComplete: (T) -> Unit,
): T {
    throw NotImplementedError("TODO")
}

fun main() {
    val events = mutableListOf<String>()
    val result = executeWithCallbacks(
        action = { 42 },
        audit = { events += "audit:$it" },
        onComplete = { events += "complete:$it" },
    )
    check(result == 42)
    check(events == listOf("audit:42", "complete:42"))
    println("C57 통과")
}
