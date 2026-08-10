package practice_by_codex

open class SpaceCargo(val name: String)
class FoodCargo(name: String) : SpaceCargo(name)

interface CargoProducer<out T> {
    fun produce(): T
}

interface CargoConsumer<in T> {
    fun consume(value: T)
}

// C41. 생산자와 소비자
// 생산한 값을 소비자에게 전달하고 같은 값을 반환하세요.
fun <T> transferCargo(producer: CargoProducer<T>, consumer: CargoConsumer<T>): T {
    throw NotImplementedError("TODO")
}

fun main() {
    val foodProducer: CargoProducer<FoodCargo> = object : CargoProducer<FoodCargo> {
        override fun produce() = FoodCargo("meal")
    }
    val generalProducer: CargoProducer<SpaceCargo> = foodProducer // out 확인

    val consumed = mutableListOf<String>()
    val generalConsumer: CargoConsumer<SpaceCargo> = object : CargoConsumer<SpaceCargo> {
        override fun consume(value: SpaceCargo) { consumed += value.name }
    }
    val foodConsumer: CargoConsumer<FoodCargo> = generalConsumer // in 확인

    check(transferCargo(generalProducer, generalConsumer).name == "meal")
    check(transferCargo(foodProducer, foodConsumer).name == "meal")
    check(consumed == listOf("meal", "meal"))
    println("C41 통과")
}
