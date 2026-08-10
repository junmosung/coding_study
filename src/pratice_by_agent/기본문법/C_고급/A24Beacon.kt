package pratice_by_agent

// A24. 비콘 송신
// Beacon 인터페이스에 transmit(message): String 을 정의하세요.
// RadioBeacon은 "RADIO:" 접두사, LaserBeacon은 "LASER:" 접두사를 붙입니다.
// 조건: 인터페이스 타입으로 호출해도 각 구현체 동작이 달라야 합니다.
interface Beacon {
    fun transmit(message: String): String
}

class RadioBeacon : Beacon {
    override fun transmit(message: String): String {
        return "" // TODO
    }
}

class LaserBeacon : Beacon {
    override fun transmit(message: String): String {
        return "" // TODO
    }
}

fun main() {
    val beacons: List<Beacon> = listOf(RadioBeacon(), LaserBeacon())
    check(beacons[0].transmit("PING") == "RADIO:PING")
    check(beacons[1].transmit("PING") == "LASER:PING")
    println("A24 통과")
}
