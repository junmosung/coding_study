package jvm_memory_learning.problems.m12

class LinkedMemoryNode(val id: String) {
    var next: LinkedMemoryNode? = null
}

// M12. 참조 graph 끊기
// head 다음의 모든 node로 향하는 edge를 끊고, 분리한 첫 node를 반환하세요.
// 객체를 삭제하는 것이 아니라 head에서 시작하는 도달 경로를 바꾸는 문제입니다.
fun detachAfter(head: LinkedMemoryNode): LinkedMemoryNode? {
    return null // TODO
}

fun main() {
    val a = LinkedMemoryNode("A")
    val b = LinkedMemoryNode("B")
    val c = LinkedMemoryNode("C")
    a.next = b
    b.next = c

    val detached = detachAfter(a)
    check(a.next == null)
    check(detached === b)
    check(detached?.next === c)
    println("M12 통과")
}
