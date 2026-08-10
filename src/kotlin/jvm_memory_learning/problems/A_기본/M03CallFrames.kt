package jvm_memory_learning.problems.m03

// M03. 호출 frame 추적
// trace가 [main:enter, calculate:enter, double:enter, double:exit,
// calculate:exit, main:exit] 순서가 되도록 두 함수를 구현하세요.
fun tracedDouble(value: Int, trace: MutableList<String>): Int {
    return 0 // TODO: enter 기록 → 계산 → exit 기록
}

fun tracedCalculate(base: Int, trace: MutableList<String>): Int {
    return 0 // TODO: enter 기록 → tracedDouble(base + 3) → exit 기록
}

fun main() {
    val trace = mutableListOf("main:enter")
    val result = tracedCalculate(10, trace)
    trace += "main:exit"

    check(result == 26)
    check(trace == listOf(
        "main:enter", "calculate:enter", "double:enter",
        "double:exit", "calculate:exit", "main:exit",
    ))
    println("M03 통과: ${trace.joinToString(" -> ")}")
}
