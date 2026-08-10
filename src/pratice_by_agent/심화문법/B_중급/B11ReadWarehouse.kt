package pratice_by_agent

// B11. 읽기 전용 창고 (공변 out)
// StockItem 계층과 Warehouse<out StockItem>을 만드세요.
// take(): StockItem 만 제공하고, 외부에서 임의 타입을 넣지 못하게 하세요.
sealed interface StockItem {
    val name: String
}

data class BoxItem(override val name: String) : StockItem
data class TubeItem(override val name: String) : StockItem

class Warehouse<out T : StockItem>(private val items: List<T>) {
    fun takeAll(): List<T> = items // 구현됨
}

// BoxItem 창고를 Warehouse<StockItem>으로 받아 이름을 모으는 함수를 작성하세요.
fun itemNames(warehouse: Warehouse<StockItem>): List<String> {
    return emptyList() // TODO
}

fun main() {
    val boxes: Warehouse<BoxItem> = Warehouse(listOf(BoxItem("B1"), BoxItem("B2")))
    val asStock: Warehouse<StockItem> = boxes // out 덕분에 대입 가능해야 함
    check(itemNames(asStock) == listOf("B1", "B2"))
    println("B11 통과")
}
