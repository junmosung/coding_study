package practice_by_agent

// B22. 티켓 정렬
// 목표: priority 내림차순, id 오름차순. sorted()만.
// 문법: Comparable
// 규칙: 자연 정렬 계약.
// 예: 3a,3c,2d,1b 순서
// 금지: sortedWith를 호출부에 전가
// 문서: docs/04_TYPE_MODELING.md

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
