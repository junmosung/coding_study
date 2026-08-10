package practice_by_claude

// ─────────────────────────────────────────────
// 코틀린 입문 연습 2회차: 조건문 if / when
// 핵심: 코틀린의 if 와 when 은 "값을 돌려주는 표현식"입니다!
// ─────────────────────────────────────────────

// [문제 1] if 표현식
// 두 정수 중 더 큰 값을 돌려주는 함수 max2 를 완성하세요.
// 조건: return 을 두 번 쓰지 말고, if 를 "값"으로 사용해서
//       한 줄(표현식 본문)로 작성해보세요.
// 힌트: val big = if (a > b) a else b   ← if 가 값을 돌려줍니다
fun max2(a: Int, b: Int) = if (a > b) a else b

// [문제 2] when 기본
// 요일 번호(1~7)를 받아 요일 이름을 돌려주는 함수를 완성하세요.
// 1 -> "월", 2 -> "화", 3 -> "수", 4 -> "목", 5 -> "금", 6 -> "토", 7 -> "일"
// 그 외 숫자 -> "없는 요일"
// 힌트: when(day) { 1 -> "월" ... else -> "없는 요일" }
fun dayName(day: Int): String {
    return when (day) {
        1 -> "월"
        2 -> "화"
        3 -> "수"
        4 -> "목"
        5 -> "금"
        6 -> "토"
        7 -> "일"
        else -> "없는 요일"
    }
}

// [문제 3] when + 범위(range)
// 점수(0~100)를 받아 학점을 돌려주는 함수를 완성하세요.
// 90 이상 -> "A", 80 이상 -> "B", 70 이상 -> "C", 그 외 -> "F"
// 힌트: when 에 조건식을 쓰는 두 가지 방법이 있어요
//   방법1: when { score >= 90 -> "A" ... }        (인자 없는 when)
//   방법2: when (score) { in 90..100 -> "A" ... } (in 과 범위 사용)
// 둘 중 편한 방법으로 작성해보세요.
fun grade(score: Int): String {
    return when {
        score >= 90 -> "A"
        score >= 80 -> "B"
        score >= 70 -> "C"
        else -> "F"
    }
}

fun main() {
    println("max2(3, 7) = ${max2(3, 7)}")       // 기대 출력: 7
    println("max2(10, 2) = ${max2(10, 2)}")     // 기대 출력: 10

    println("dayName(1) = ${dayName(1)}")       // 기대 출력: 월
    println("dayName(6) = ${dayName(6)}")       // 기대 출력: 토
    println("dayName(9) = ${dayName(9)}")       // 기대 출력: 없는 요일

    println("grade(95) = ${grade(95)}")         // 기대 출력: A
    println("grade(81) = ${grade(81)}")         // 기대 출력: B
    println("grade(70) = ${grade(70)}")         // 기대 출력: C
    println("grade(42) = ${grade(42)}")         // 기대 출력: F
}
