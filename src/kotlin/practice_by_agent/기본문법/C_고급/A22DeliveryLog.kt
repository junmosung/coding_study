package practice_by_agent

// A22. 배송 기록
// 목표: markDelivered는 status만 DELIVERED인 copy.
// 문법: data class, copy
// 규칙: 원본 불변. == 값, === 참조.
// 예: 원본 SHIPPING 유지, 복사본 DELIVERED
// 금지: 원본 필드 직접 변경
// 문서: docs/04_TYPE_MODELING.md

data class DeliveryLog(val id: String, val status: String, val memo: String)

fun markDelivered(log: DeliveryLog): DeliveryLog {
    return log // TODO
}

fun main() {
    val original = DeliveryLog("L1", "SHIPPING", "fragile")
    val updated = markDelivered(original)
    check(updated == DeliveryLog("L1", "DELIVERED", "fragile"))
    check(original.status == "SHIPPING")
    check(original !== updated)
    check(original.copy(status = "DELIVERED") == updated)
    println("A22 통과")
}
