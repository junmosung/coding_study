package practice_by_codex

// C06. 행성 코드 해석
// M은 MARS, V는 VENUS, E는 EARTH로 변환하세요.
// 대소문자를 구분하지 않고, 나머지는 UNKNOWN을 반환합니다.
// 조건: when을 사용하세요.
fun planetName(code: Char): String {
    return "" // TODO
}

fun main() {
    check(planetName('M') == "MARS")
    check(planetName('v') == "VENUS")
    check(planetName('e') == "EARTH")
    check(planetName('X') == "UNKNOWN")
    println("C06 통과")
}
