package pratice_by_agent

// B19. 관제탑 DSL
// tower { ... } 빌더로 TowerConfig를 반환하세요.
// 조건: 람다 with receiver (TowerConfig.() -> Unit)를 사용하세요.
class TowerConfig {
    var name: String = ""
    var maxDrones: Int = 0
    var isOpen: Boolean = false
        private set

    fun open() {
        // TODO: isOpen = true
    }
}

fun tower(block: TowerConfig.() -> Unit): TowerConfig {
    return TowerConfig() // TODO
}

fun main() {
    val config = tower {
        name = "SEOUL"
        maxDrones = 8
        open()
    }
    check(config.name == "SEOUL")
    check(config.maxDrones == 8)
    check(config.isOpen)
    println("B19 통과")
}
