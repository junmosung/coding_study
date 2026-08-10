package pratice_by_agent

// B01. 배송 검증
// weightKg > 0 이 아니면 require로 실패하세요.
// locked == true 가 아니면 check로 실패하세요.
// 성공 시 "OK"를 반환하세요.
// 조건: require / check를 사용하고, 예외 메시지에 실패 조건을 포함하세요.
fun validateShipment(weightKg: Int, locked: Boolean): String {
    return "" // TODO
}

fun main() {
    check(validateShipment(3, true) == "OK")
    try {
        validateShipment(0, true)
        error("require가 호출되어야 합니다")
    } catch (e: IllegalArgumentException) {
        check(e.message != null && e.message!!.isNotBlank())
    }
    try {
        validateShipment(2, false)
        error("check가 호출되어야 합니다")
    } catch (e: IllegalStateException) {
        check(e.message != null && e.message!!.isNotBlank())
    }
    println("B01 통과")
}
