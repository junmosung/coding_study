package practice_by_codex

// C11. 센서값 파싱
// raw를 Int로 변환하고 값이 0..100이면 반환하세요.
// 숫자가 아니거나 범위 밖이면 null을 반환합니다.
// 조건: 예외 처리 대신 toIntOrNull과 takeIf를 사용하세요.
fun parseSensorValue(raw: String): Int? {
    return null // TODO
}

fun main() {
    check(parseSensorValue("42") == 42)
    check(parseSensorValue("0") == 0)
    check(parseSensorValue("101") == null)
    check(parseSensorValue("error") == null)
    println("C11 통과")
}
