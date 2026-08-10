package pratice_by_codex

// C14. 자원 이름표
// 각 자원명을 "순번. 대문자이름" 형식으로 변환하세요. 순번은 1부터 시작합니다.
// 조건: mapIndexed를 사용하세요.
// 예: ["water", "Food"] -> ["1. WATER", "2. FOOD"]
fun resourceLabels(resources: List<String>): List<String> {
    return emptyList() // TODO
}

fun main() {
    check(resourceLabels(listOf("water", "Food")) == listOf("1. WATER", "2. FOOD"))
    check(resourceLabels(emptyList()) == emptyList<String>())
    println("C14 통과")
}
