package practice_by_agent

// A25. 배송 대상
// 목표: Home/Locker/Unknown 안내. else 금지.
// 문법: sealed class, exhaustive when
// 규칙: 하위 타입 추가 시 컴파일 에러 나도록.
// 예: Home("Seoul 1") → "자택 배송: Seoul 1"
// 금지: else 사용
// 문서: docs/04_TYPE_MODELING.md

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
