package practice_by_codex

// C12. 예비 좌표 선택
// primary가 있으면 primary, 없으면 backup을 "좌표: 값" 형태로 반환하세요.
// 둘 다 null이면 "좌표 없음"을 반환합니다.
// 조건: 엘비스 연산자를 사용하고 !!는 사용하지 마세요.
fun selectCoordinate(primary: String?, backup: String?): String {
    return "" // TODO
}

fun main() {
    check(selectCoordinate("A-10", "B-20") == "좌표: A-10")
    check(selectCoordinate(null, "B-20") == "좌표: B-20")
    check(selectCoordinate(null, null) == "좌표 없음")
    println("C12 통과")
}
