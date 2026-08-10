package practice_by_codex

@DslMarker
annotation class MissionDsl

data class MissionPlan(
    val destination: String,
    val crew: List<String>,
    val equipment: List<String>,
)

@MissionDsl
class EquipmentBuilder {
    private val values = mutableListOf<String>()
    fun item(name: String) { values += name }
    fun build(): List<String> = values.toList()
}

@MissionDsl
class MissionPlanBuilder {
    var destination: String = ""
    private val crewMembers = mutableListOf<String>()
    private var equipmentItems = emptyList<String>()

    fun crew(name: String) {
        // TODO
    }

    fun equipment(block: EquipmentBuilder.() -> Unit) {
        // TODO
    }

    fun build(): MissionPlan {
        // destination이 비었으면 require로 거절하세요.
        return MissionPlan("", emptyList(), emptyList()) // TODO
    }
}

// C58. 임무 설정 DSL
fun missionPlan(block: MissionPlanBuilder.() -> Unit): MissionPlan {
    throw NotImplementedError("TODO")
}

fun main() {
    val plan = missionPlan {
        destination = "Mars"
        crew("Neo")
        crew("Trinity")
        equipment {
            item("Scanner")
            item("Radio")
        }
    }
    check(plan == MissionPlan("Mars", listOf("Neo", "Trinity"), listOf("Scanner", "Radio")))
    check(runCatching { missionPlan { crew("Neo") } }.isFailure)
    println("C58 통과")
}
