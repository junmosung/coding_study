package pratice_by_agent

// A14. 화물 이름표
// 각 이름을 대문자로 바꾼 뒤 "1. WATER", "2. FOOD" 형식으로 변환하세요.
// 조건: mapIndexed를 사용하세요. 인덱스는 1부터 표기합니다.
fun cargoLabels(names: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    check(cargoLabels(listOf("water", "food")) == listOf("1. WATER", "2. FOOD"))
    check(cargoLabels(emptyList()) == emptyList<String>())
    println("A14 통과")
}
