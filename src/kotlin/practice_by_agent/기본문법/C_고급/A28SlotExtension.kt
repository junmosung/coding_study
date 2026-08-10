package practice_by_agent

// A28. 슬롯 확장
// 목표: trim → 연속공백을 - → 대문자.
// 문법: 확장 함수, Regex/문자열 처리
// 규칙: 멤버가 실제로 추가되는 것은 아님.
// 예: "  bay  7  ".toSlotCode()=="BAY-7"
// 금지: 상속으로 String 확장
// 문서: docs/07_EXTENSIONS_SCOPE_DELEGATION.md

fun String.toSlotCode(): String {
    return "" // TODO
}

fun main() {
    check("  bay  7  ".toSlotCode() == "BAY-7")
    check("dock A".toSlotCode() == "DOCK-A")
    check("X".toSlotCode() == "X")
    println("A28 통과")
}
