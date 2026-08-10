package practice_by_codex

// C05. 위험 등급
// risk를 다음 규칙으로 분류하세요.
// 0..24 LOW, 25..49 MEDIUM, 50..74 HIGH, 75..100 CRITICAL
// 0..100 밖의 값은 INVALID입니다.
// 조건: when과 in 범위를 사용하세요.
fun riskLevel(risk: Int): String {
    return "" // TODO
}

fun main() {
    check(riskLevel(-1) == "INVALID")
    check(riskLevel(0) == "LOW")
    check(riskLevel(25) == "MEDIUM")
    check(riskLevel(74) == "HIGH")
    check(riskLevel(100) == "CRITICAL")
    check(riskLevel(101) == "INVALID")
    println("C05 통과")
}
