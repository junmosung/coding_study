package practice_by_agent

// B21. 관제 사건
// 목표: Online/Offline/StockLow 문구. else 금지.
// 문법: sealed interface, when
// 규칙: 완전 분기.
// 예: ONLINE:D1 / LOW:bolt:2
// 금지: else
// 문서: docs/04_TYPE_MODELING.md

sealed interface TowerEvent {
    data class DroneOnline(val id: String) : TowerEvent
    data class DroneOffline(val id: String) : TowerEvent
    data class StockLow(val item: String, val qty: Int) : TowerEvent
}

fun describe(event: TowerEvent): String {
    return "" // TODO
}

fun main() {
    check(describe(TowerEvent.DroneOnline("D1")) == "ONLINE:D1")
    check(describe(TowerEvent.DroneOffline("D2")) == "OFFLINE:D2")
    check(describe(TowerEvent.StockLow("bolt", 2)) == "LOW:bolt:2")
    println("B21 통과")
}
