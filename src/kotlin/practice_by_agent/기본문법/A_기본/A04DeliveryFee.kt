package practice_by_agent

// A04. 배송비
// 목표: 5kg 이하 3000원, 초과 시 3000+(무게-5)*500.
// 문법: if 표현식
// 규칙: 결과를 바로 반환.
// 예: deliveryFee(5)==3000, deliveryFee(7)==4000
// 금지: 임시 var에 요금 담기
// 문서: docs/01_BASIC_SYNTAX.md

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
