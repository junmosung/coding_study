package jvm_memory_learning.problems.m02

data class MemoryBox(val label: String, var value: Int)

// M02. 객체 반환
// 함수 안에서 MemoryBox를 생성해 반환하세요.
// createBox의 frame이 사라져도 caller가 반환 reference를 보유합니다.
fun createBox(label: String, value: Int): MemoryBox {
    return MemoryBox("TODO", 0) // TODO
}

fun main() {
    val box = createBox("heap", 42)
    check(box == MemoryBox("heap", 42))
    box.value++
    check(box.value == 43)
    println("M02 통과: $box")
}
