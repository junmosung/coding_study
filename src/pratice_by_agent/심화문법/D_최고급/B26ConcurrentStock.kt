package pratice_by_agent

import java.util.concurrent.ConcurrentHashMap

// B26. 동시성 재고 맵
// addStock은 수량을 더하고, takeStock은 충분하면 차감 후 true, 부족하면 false.
// 조건: ConcurrentHashMap을 사용하세요.
class ConcurrentStock {
    private val stock = ConcurrentHashMap<String, Int>()

    fun addStock(item: String, amount: Int) {
        // TODO
    }

    fun takeStock(item: String, amount: Int): Boolean {
        return false // TODO
    }

    fun get(item: String): Int = stock[item] ?: 0
}

fun main() {
    val stock = ConcurrentStock()
    stock.addStock("bolt", 5)
    check(stock.takeStock("bolt", 3))
    check(stock.get("bolt") == 2)
    check(!stock.takeStock("bolt", 5))
    check(stock.get("bolt") == 2)
    check(!stock.takeStock("nut", 1))
    println("B26 통과")
}
