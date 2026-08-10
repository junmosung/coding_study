package practice_by_agent

// B19. 관제 DSL
// 목표: tower { name; maxDrones; open() }.
// 문법: 람다 with receiver
// 규칙: TowerConfig.() -> Unit.
// 예: SEOUL, 8, isOpen true
// 금지: 빌더를 일반 람다로만
// 문서: docs/07_EXTENSIONS_SCOPE_DELEGATION.md

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
