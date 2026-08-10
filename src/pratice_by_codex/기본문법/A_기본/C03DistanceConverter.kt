package pratice_by_codex

// C03. 거리 단위 변환
// 정수 미터 값을 Double 타입의 킬로미터 값으로 변환하세요.
// 조건: 정수 나눗셈으로 소수점이 사라지지 않아야 합니다.
// 예: toKilometers(1_500) == 1.5, toKilometers(250) == 0.25
fun toKilometers(meters: Int): Double {
    return 0.0 // TODO
}

fun main() {
    check(toKilometers(1_500) == 1.5)
    check(toKilometers(250) == 0.25)
    check(toKilometers(0) == 0.0)
    println("C03 통과")
}
