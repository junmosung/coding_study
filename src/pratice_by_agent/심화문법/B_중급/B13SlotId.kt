package pratice_by_agent

// B13. 슬롯 ID 값 클래스
// 빈 문자열이 아닌 SlotId만 허용하세요.
// openSlot은 SlotId만 받고, 일반 String으로는 호출할 수 없게 하세요.
@JvmInline
value class SlotId(val value: String) {
    init {
        // TODO: 빈 문자열이면 require 실패
    }
}

fun openSlot(id: SlotId): String {
    return "" // TODO: "OPEN:{value}"
}

fun main() {
    check(openSlot(SlotId("A-1")) == "OPEN:A-1")
    try {
        SlotId("")
        error("빈 SlotId는 실패해야 합니다")
    } catch (_: IllegalArgumentException) {
    }
    // openSlot("A-1") // 컴파일 에러여야 함 (호출하지 마세요)
    println("B13 통과")
}
