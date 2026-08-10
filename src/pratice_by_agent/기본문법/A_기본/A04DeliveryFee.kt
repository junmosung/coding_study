package pratice_by_agent

// A04. 배송비 계산
// 무게(kg)가 5 이하면 3000원, 초과하면 3000 + (무게-5)*500 원을 반환하세요.
// 조건: if 표현식으로 결과를 바로 반환하세요.
fun deliveryFee(weightKg: Int): Int {
    return 0 // TODO
}

fun main() {
    check(deliveryFee(1) == 3000)
    check(deliveryFee(5) == 3000)
    check(deliveryFee(7) == 4000)
    check(deliveryFee(10) == 5500)
    println("A04 통과")
}
