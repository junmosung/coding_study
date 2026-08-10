package practice_by_agent

// A12. 센서 파싱
// 목표: Int 변환 후 0..100만 성공, 실패 null.
// 문법: toIntOrNull, takeIf
// 규칙: 예외 던지지 않음.
// 예: parseSensor("42")==42, parseSensor("101")==null
// 금지: try/catch로 파싱
// 문서: docs/02_NULL_SAFETY.md

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
