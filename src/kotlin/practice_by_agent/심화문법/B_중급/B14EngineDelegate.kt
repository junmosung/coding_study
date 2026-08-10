package practice_by_agent

// B14. 엔진 위임
// 목표: TowerDrone: Engine by engine + fly().
// 문법: 클래스 위임 by
// 규칙: start/stop은 위임, fly는 자체.
// 예: fly()=="FLY:D7"
// 금지: Engine 메서드 전부 수동 포워딩
// 문서: docs/07_EXTENSIONS_SCOPE_DELEGATION.md

interface Engine {
    fun start(): String
    fun stop(): String
}

class SimpleEngine : Engine {
    override fun start(): String = "START"
    override fun stop(): String = "STOP"
}

class TowerDrone(
    val name: String,
    engine: Engine,
) : Engine by engine {
    fun fly(): String {
        return "" // TODO
    }
}

fun main() {
    val drone = TowerDrone("D7", SimpleEngine())
    check(drone.start() == "START")
    check(drone.stop() == "STOP")
    check(drone.fly() == "FLY:D7")
    println("B14 통과")
}
