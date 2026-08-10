package practice_by_agent

// A05. 우선순위 등급
// 목표: 0..24 LOW, 25..49 NORMAL, 50..74 HIGH, 75..100 URGENT, 그 외 INVALID.
// 문법: when, in, IntRange
// 규칙: 경계값 포함 여부 정확히.
// 예: priorityLevel(25)=="NORMAL", priorityLevel(101)=="INVALID"
// 금지: 범위 겹침/누락
// 문서: docs/01_BASIC_SYNTAX.md

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
