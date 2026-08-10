package practice_by_agent

// B09. 인라인 타이머
// 목표: block 결과와 경과 ms.
// 문법: inline 고차 함수
// 규칙: inline으로 선언.
// 예: sleep 후 elapsed>=15
// 금지: inline 없는 래퍼만
// 문서: docs/06_GENERICS_VARIANCE.md

inline fun <T> measureMs(block: () -> T): Pair<T, Long> {
    return block() to 0L // TODO: 실제 경과 시간 측정
}

fun main() {
    val (value, elapsed) = measureMs {
        Thread.sleep(20)
        42
    }
    check(value == 42)
    check(elapsed >= 15)
    println("B09 통과 (elapsed=${elapsed}ms)")
}
