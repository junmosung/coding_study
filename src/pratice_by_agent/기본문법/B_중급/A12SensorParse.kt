package pratice_by_agent

// A12. 센서값 파싱
// 문자열을 Int로 바꾸되 실패하면 null을 반환하세요.
// 변환값이 0..100 밖이어도 null을 반환하세요.
// 조건: toIntOrNull과 takeIf를 사용하세요.
fun parseSensor(raw: String): Int? {
    return null // TODO
}

fun main() {
    check(parseSensor("42") == 42)
    check(parseSensor("0") == 0)
    check(parseSensor("100") == 100)
    check(parseSensor("101") == null)
    check(parseSensor("-1") == null)
    check(parseSensor("nope") == null)
    println("A12 통과")
}
