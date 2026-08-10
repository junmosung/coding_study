package practice_by_agent

// B24. Future 수집
// 목표: 병렬 Int 파싱, 실패 스킵.
// 문법: Future, submit/invokeAll
// 규칙: 성공 값만 수집.
// 예: ["1","x","3","2"] → [1,2,3] (정렬 후)
// 금지: 단일 스레드만
// 문서: docs/10_JAVA_INTEROP.md

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun parseAllAsync(rawValues: List<String>, poolSize: Int = 2): List<Int> {
    return emptyList() // TODO
}

fun main() {
    val result = parseAllAsync(listOf("1", "x", "3", "2"), poolSize = 2).sorted()
    check(result == listOf(1, 2, 3))
    check(parseAllAsync(emptyList()) == emptyList<Int>())
    println("B24 통과")
}
