package pratice_by_agent

// A22. 배송 기록
// DeliveryLog(id, status, memo) data class를 선언하세요.
// markDelivered는 원본을 바꾸지 않고 status만 "DELIVERED"인 복사본을 반환합니다.
// 조건: copy를 사용하세요.
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
