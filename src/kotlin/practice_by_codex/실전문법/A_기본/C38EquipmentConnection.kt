package practice_by_codex

data class Equipment(val name: String)

class EquipmentBay {
    // C38. 장비 연결 상태
    // nullable 타입 대신 lateinit을 사용하세요.
    private lateinit var equipment: Equipment

    val isConnected: Boolean
        get() = false // TODO: ::equipment.isInitialized

    fun connect(value: Equipment) {
        // TODO
    }

    fun connectedName(): String = equipment.name
}

fun main() {
    val bay = EquipmentBay()
    check(!bay.isConnected)
    check(runCatching { bay.connectedName() }.exceptionOrNull() is UninitializedPropertyAccessException)
    bay.connect(Equipment("Scanner"))
    check(bay.isConnected)
    check(bay.connectedName() == "Scanner")
    println("C38 통과")
}
