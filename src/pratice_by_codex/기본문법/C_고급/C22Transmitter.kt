package pratice_by_codex

// C22. 신호 송신 장치
// 아래 인터페이스를 두 클래스가 구현하도록 완성하세요.
// RadioTransmitter.send("SOS")는 "[RADIO] SOS",
// LaserTransmitter.send("SOS")는 "[LASER] SOS"를 반환합니다.
interface Transmitter {
    fun send(message: String): String
}

class RadioTransmitter : Transmitter {
    override fun send(message: String): String {
        return "" // TODO
    }
}

class LaserTransmitter : Transmitter {
    override fun send(message: String): String {
        return "" // TODO
    }
}

fun main() {
    val transmitters: List<Transmitter> = listOf(RadioTransmitter(), LaserTransmitter())
    check(transmitters.map { it.send("SOS") } == listOf("[RADIO] SOS", "[LASER] SOS"))
    println("C22 통과")
}
