package practice_by_agent

// B18. 단위 infix
// 목표: cargo(name) weighing kg.
// 문법: infix
// 규칙: 읽히는 DSL 수준만.
// 예: cargo("bolt") weighing 3
// 금지: infix 남발로 가독성 저하
// 문서: docs/03_FUNCTIONS_LAMBDAS.md

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
