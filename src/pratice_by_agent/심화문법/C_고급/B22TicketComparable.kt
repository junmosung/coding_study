package pratice_by_agent

// B22. 우선순위 비교
// Ticket은 priority 내림차순, 동점이면 id 오름차순으로 자연 정렬되어야 합니다.
// 조건: Comparable을 구현하고 sorted()만으로 검증하세요.
data class Ticket(val priority: Int, val id: String) : Comparable<Ticket> {
    override fun compareTo(other: Ticket): Int {
        return 0 // TODO
    }
}

fun main() {
    val tickets = listOf(
        Ticket(1, "b"),
        Ticket(3, "c"),
        Ticket(3, "a"),
        Ticket(2, "d"),
    )
    check(
        tickets.sorted() == listOf(
            Ticket(3, "a"),
            Ticket(3, "c"),
            Ticket(2, "d"),
            Ticket(1, "b"),
        )
    )
    println("B22 통과")
}
