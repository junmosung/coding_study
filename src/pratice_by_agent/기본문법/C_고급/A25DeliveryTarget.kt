package pratice_by_agent

// A25. 배송 대상
// sealed class로 Home(address), Locker(code), Unknown을 표현하세요.
// guide 함수는 대상별 안내 문구를 반환하되 when에서 else를 사용하지 마세요.
// Home -> "자택 배송: {address}"
// Locker -> "보관함 #{code}"
// Unknown -> "대상을 확인할 수 없습니다"
sealed class DeliveryTarget {
    data class Home(val address: String) : DeliveryTarget()
    data class Locker(val code: Int) : DeliveryTarget()
    object Unknown : DeliveryTarget()
}

fun deliveryGuide(target: DeliveryTarget): String {
    return "" // TODO
}

fun main() {
    check(deliveryGuide(DeliveryTarget.Home("Seoul 1")) == "자택 배송: Seoul 1")
    check(deliveryGuide(DeliveryTarget.Locker(42)) == "보관함 #42")
    check(deliveryGuide(DeliveryTarget.Unknown) == "대상을 확인할 수 없습니다")
    println("A25 통과")
}
