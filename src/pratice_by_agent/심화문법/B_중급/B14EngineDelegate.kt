package pratice_by_agent

// B14. 엔진 인터페이스 위임
// Engine 구현을 by로 위임하는 TowerDrone을 만드세요.
// TowerDrone은 fly()에서 "FLY:{name}"을 반환합니다.
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
