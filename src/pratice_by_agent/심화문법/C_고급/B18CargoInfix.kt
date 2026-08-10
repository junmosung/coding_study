package pratice_by_agent

// B18. 단위 infix
// cargo("bolt") weighing 3 형태로 CargoSpec을 만드세요.
data class CargoSpec(val name: String, val kg: Int)

class CargoName(val name: String) {
    infix fun weighing(kg: Int): CargoSpec {
        return CargoSpec("", 0) // TODO
    }
}

fun cargo(name: String): CargoName = CargoName(name)

fun main() {
    check((cargo("bolt") weighing 3) == CargoSpec("bolt", 3))
    check((cargo("nut") weighing 1) == CargoSpec("nut", 1))
    println("B18 통과")
}
