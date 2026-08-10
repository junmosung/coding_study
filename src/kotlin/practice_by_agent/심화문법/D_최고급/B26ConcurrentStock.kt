package practice_by_agent

// B26. 동시성 재고
// 목표: addStock/takeStock. 부족 시 false.
// 문법: ConcurrentHashMap
// 규칙: 스레드 안전.
// 예: 5에서 3 성공→2, 5 실패
// 금지: 일반 HashMap+광역락만
// 문서: docs/10_JAVA_INTEROP.md

import java.util.concurrent.ConcurrentHashMap

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
