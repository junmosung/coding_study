package jvm_memory_learning.problems.m05

data class ReferenceBox(var value: Int)

// M05. 참조 값 전달
// 같은 ReferenceBox 객체의 value만 delta만큼 변경하세요.
// 새 ReferenceBox를 만들어 parameter 변수에 대입하는 방식으로는 caller 객체가 바뀌지 않습니다.
fun mutateBox(box: ReferenceBox, delta: Int) {
    // TODO
}

fun main() {
    val box = ReferenceBox(10)
    val identityBefore = System.identityHashCode(box)
    mutateBox(box, 7)

    check(box.value == 17)
    check(System.identityHashCode(box) == identityBefore)
    println("M05 통과")
}
