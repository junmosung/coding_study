package practice_by_agent

// B13. 슬롯 ID
// 목표: 빈 문자열 금지 SlotId. openSlot은 SlotId만.
// 문법: @JvmInline value class
// 규칙: String과 타입 구분.
// 예: openSlot(SlotId("A-1"))=="OPEN:A-1"
// 금지: typealias String로 대체
// 문서: docs/04_TYPE_MODELING.md

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
