package pratice_by_codex

// C04. 착륙 허가
// 연료가 30 이상이고 풍속이 20 이하일 때만 true를 반환하세요.
// 조건: && 연산자를 사용한 하나의 Boolean 표현식으로 작성하세요.
fun canLand(fuel: Int, wind: Int): Boolean {
    return false // TODO
}

fun main() {
    check(canLand(fuel = 40, wind = 15))
    check(canLand(fuel = 30, wind = 20))
    check(!canLand(fuel = 29, wind = 10))
    check(!canLand(fuel = 50, wind = 21))
    println("C04 통과")
}
