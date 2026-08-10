package jvm_memory_learning.problems.m07

data class MemoryPoint(val x: Int, val y: Int)

data class EqualityResult(
    val structurallyEqual: Boolean,
    val sameReference: Boolean,
)

// M07. ==와 ===
fun comparePoints(left: MemoryPoint, right: MemoryPoint): EqualityResult {
    return EqualityResult(false, false) // TODO
}

fun main() {
    val first = MemoryPoint(1, 2)
    val equalButNew = MemoryPoint(1, 2)
    val alias = first

    check(comparePoints(first, equalButNew) == EqualityResult(true, false))
    check(comparePoints(first, alias) == EqualityResult(true, true))
    check(comparePoints(first, MemoryPoint(9, 9)) == EqualityResult(false, false))
    println("M07 통과")
}
