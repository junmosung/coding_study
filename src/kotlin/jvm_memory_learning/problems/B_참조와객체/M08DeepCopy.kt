package jvm_memory_learning.problems.m08

data class MemoryMember(val name: String, val skills: MutableList<String>)
data class MemoryTeam(val name: String, val members: MutableList<MemoryMember>)

// M08. 깊은 복사
// Team, members list, 각 Member, 각 skills list를 모두 분리하세요.
fun deepCopyTeam(source: MemoryTeam): MemoryTeam {
    return source // TODO
}

fun main() {
    val original = MemoryTeam(
        "runtime",
        mutableListOf(MemoryMember("Kim", mutableListOf("Stack"))),
    )
    val copied = deepCopyTeam(original)
    copied.members.first().skills += "Heap"
    copied.members += MemoryMember("Lee", mutableListOf("GC"))

    check(original.members.size == 1)
    check(original.members.first().skills == listOf("Stack"))
    check(original !== copied)
    check(original.members !== copied.members)
    check(original.members.first() !== copied.members.first())
    println("M08 통과")
}
