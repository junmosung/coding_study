package jvm_memory_learning.problems.m01

// M01. 값 복사
// parameter에는 caller의 Int 값이 복사됩니다.
// 전달받은 값에 delta를 더한 결과를 반환하되 caller의 변수는 바뀌지 않아야 합니다.
fun addToCopy(value: Int, delta: Int): Int {
    return 0 // TODO
}

fun main() {
    val original = 10
    val changed = addToCopy(original, 5)

    check(original == 10)
    check(changed == 15)
    check(addToCopy(-3, 3) == 0)
    println("M01 통과")
}
