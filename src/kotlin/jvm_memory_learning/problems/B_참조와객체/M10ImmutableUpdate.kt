package jvm_memory_learning.problems.m10

data class AppMemoryState(val version: Int, val labels: List<String>)

// M10. 불변 상태 교체
// source를 변경하지 않고 label을 추가한 새 상태를 반환하세요.
fun addLabel(source: AppMemoryState, label: String): AppMemoryState {
    return source // TODO
}

fun main() {
    val original = AppMemoryState(1, listOf("Stack"))
    val updated = addLabel(original, "Heap")

    check(original == AppMemoryState(1, listOf("Stack")))
    check(updated == AppMemoryState(2, listOf("Stack", "Heap")))
    check(original !== updated)
    println("M10 통과")
}
