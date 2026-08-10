package practice_by_agent

// A24. 비콘
// 목표: RADIO:/LASER: 접두사 transmit.
// 문법: interface, override, 다형성
// 규칙: List<Beacon>으로 호출.
// 예: RadioBeacon().transmit("PING")=="RADIO:PING"
// 금지: when으로 타입 분기 강제
// 문서: docs/04_TYPE_MODELING.md

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
