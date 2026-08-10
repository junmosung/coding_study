package pratice_by_agent

// B21. 관제 사건
// sealed interface TowerEvent와 하위 타입을 정의하세요.
// describe는 else 없이 when으로 안내 문구를 반환합니다.
// DroneOnline(id) -> "ONLINE:{id}"
// DroneOffline(id) -> "OFFLINE:{id}"
// StockLow(item, qty) -> "LOW:{item}:{qty}"
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
