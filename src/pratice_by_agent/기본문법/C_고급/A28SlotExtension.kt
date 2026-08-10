package pratice_by_agent

// A28. 슬롯 확장 함수
// String.toSlotCode() 확장 함수를 작성하세요.
// 앞뒤 공백 제거 → 연속 공백을 하이픈 하나로 → 대문자
// 예: "  bay  7  " -> "BAY-7"
// 조건: 확장 함수로 작성하고 정규식 또는 동등한 문자열 처리를 사용하세요.
fun String.toSlotCode(): String {
    return "" // TODO
}

fun main() {
    check("  bay  7  ".toSlotCode() == "BAY-7")
    check("dock A".toSlotCode() == "DOCK-A")
    check("X".toSlotCode() == "X")
    println("A28 통과")
}
