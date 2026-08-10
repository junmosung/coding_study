package pratice_by_agent

// A05. 우선순위 등급
// score를 다음 규칙으로 분류하세요.
// 0..24 LOW, 25..49 NORMAL, 50..74 HIGH, 75..100 URGENT
// 0..100 밖의 값은 INVALID입니다.
// 조건: when과 in 범위를 사용하세요.
fun priorityLevel(score: Int): String {
    return "" // TODO
}

fun main() {
    check(priorityLevel(-1) == "INVALID")
    check(priorityLevel(0) == "LOW")
    check(priorityLevel(25) == "NORMAL")
    check(priorityLevel(74) == "HIGH")
    check(priorityLevel(100) == "URGENT")
    check(priorityLevel(101) == "INVALID")
    println("A05 통과")
}
