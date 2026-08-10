fun main() {
    println("=== 1. List (즉시 처리 / eager) ===")
    val listResult = listOf(1, 2, 3, 4, 5)
        .map {
            println("  map: $it")      // 언제 찍히는지 관찰
            it * 2
        }
        .filter {
            println("  filter: $it")
            it > 4
        }
    println(">> 결과 꺼내기 전")
    println(">> 결과: $listResult")


    println("\n=== 2. Sequence (지연 처리 / lazy) ===")
    val seq = listOf(1, 2, 3, 4, 5).asSequence()
        .map {
            println("  map: $it")
            it * 2
        }
        .filter {
            println("  filter: $it")
            it > 4
        }
    println(">> 아직 아무것도 안 찍힘 (map/filter가 미뤄짐)")
    val seqResult = seq.toList()       // ← 이 순간 실제 실행!
    println(">> 결과: $seqResult")


    println("\n=== 3. Sequence + first() : 필요한 만큼만 ===")
    val firstResult = listOf(1, 2, 3, 4, 5).asSequence()
        .map {
            println("  map: $it")
            it * 2
        }
        .filter {
            println("  filter: $it")
            it > 4
        }
        .first()                       // 첫 결과만 필요 → 찾으면 즉시 멈춤
    println(">> first 결과: $firstResult")
}
