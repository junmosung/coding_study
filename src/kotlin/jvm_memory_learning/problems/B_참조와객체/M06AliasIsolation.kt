package jvm_memory_learning.problems.m06

data class MutableProfile(val name: String, val tags: MutableList<String>)

// M06. alias 분리
// source와 tags 객체를 공유하지 않는 새 Profile을 반환하세요.
fun isolateProfile(source: MutableProfile): MutableProfile {
    return source // TODO
}

fun main() {
    val original = MutableProfile("Kotlin", mutableListOf("JVM"))
    val isolated = isolateProfile(original)
    isolated.tags += "Heap"

    check(original == MutableProfile("Kotlin", mutableListOf("JVM")))
    check(isolated.tags == listOf("JVM", "Heap"))
    check(original !== isolated)
    check(original.tags !== isolated.tags)
    println("M06 통과")
}
