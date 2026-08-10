package practice_by_agent

// B11. 읽기 창고
// 목표: Warehouse<out StockItem> 공변 읽기.
// 문법: out 변성
// 규칙: Warehouse<BoxItem>을 Warehouse<StockItem>으로 사용.
// 예: itemNames(asStock)==[B1,B2]
// 금지: 가변 리스트 외부 노출
// 문서: docs/06_GENERICS_VARIANCE.md

sealed interface StockItem {
    val name: String
}

data class BoxItem(override val name: String) : StockItem
data class TubeItem(override val name: String) : StockItem

class Warehouse<out T : StockItem>(private val items: List<T>) {
    fun takeAll(): List<T> = items // 구현됨
}

fun itemNames(warehouse: Warehouse<StockItem>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val boxes: Warehouse<BoxItem> = Warehouse(listOf(BoxItem("B1"), BoxItem("B2")))
    val asStock: Warehouse<StockItem> = boxes // out 덕분에 대입 가능해야 함
    check(itemNames(asStock) == listOf("B1", "B2"))
    println("B11 통과")
}
