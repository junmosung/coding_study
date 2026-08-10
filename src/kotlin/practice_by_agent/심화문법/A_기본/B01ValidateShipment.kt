package practice_by_agent

// B01. 배송 검증
// 목표: weightKg>0은 require, locked는 check. 성공 시 OK.
// 문법: require, check
// 규칙: 예외 메시지에 실패 조건 포함.
// 예: validateShipment(3,true)=="OK"
// 금지: 모든 실패를 하나의 Exception으로
// 문서: docs/08_ERRORS_RESULT.md

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
