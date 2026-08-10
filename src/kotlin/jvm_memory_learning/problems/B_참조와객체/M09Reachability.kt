package jvm_memory_learning.problems.m09

data class GraphNode(val id: String, val references: MutableList<GraphNode> = mutableListOf())

// M09. GC root 기반 도달 가능성
// roots에서 references를 따라 도달 가능한 모든 id를 반환하세요.
// cycle이 있어도 무한 반복하면 안 됩니다.
fun reachableIds(roots: List<GraphNode>): Set<String> {
    return emptySet() // TODO
}

fun main() {
    val user = GraphNode("user")
    val address = GraphNode("address")
    user.references += address

    val orphanA = GraphNode("orphan-a")
    val orphanB = GraphNode("orphan-b")
    orphanA.references += orphanB
    orphanB.references += orphanA

    check(reachableIds(listOf(user)) == setOf("user", "address"))
    check("orphan-a" !in reachableIds(listOf(user)))
    check(reachableIds(listOf(orphanA)) == setOf("orphan-a", "orphan-b"))
    println("M09 통과")
}
