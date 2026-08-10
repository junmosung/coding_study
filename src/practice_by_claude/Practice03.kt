package practice_by_claude

// ─────────────────────────────────────────────
// 코틀린 입문 연습 3회차: 반복문 for / while / 범위(range)
// ─────────────────────────────────────────────

// [문제 1] for + 범위
// 1부터 n까지의 합을 돌려주는 함수를 완성하세요.
// 힌트: for (i in 1..n) { ... }  ← .. 은 양 끝을 모두 포함합니다
fun sumTo(n: Int): Int {
    var total = 0
    // TODO: for 문으로 total 에 1~n 을 더하세요
    for (i in 1..n)
        total += i

    return total
}

// [문제 2] 다양한 범위 문법
// n부터 1까지 "거꾸로" 숫자를 한 줄에 공백으로 이어 출력하는 함수를 완성하세요.
// 예: countdown(5) → "5 4 3 2 1"
// 힌트: for (i in n downTo 1) { ... }
//       문자열에 이어붙일 때는 result += "$i " 처럼 쓸 수 있어요
fun countdown(n: Int): String {
    var result = ""

    for (i in n downTo 1) {
        result += "$i "
    }

    return result.trim() // trim() 은 양 끝 공백 제거
}

// [문제 3] while + 조건
// 어떤 수가 2로 몇 번 나눠떨어지는지 세는 함수를 완성하세요.
// 예: halveCount(8) → 3   (8 → 4 → 2 → 1, 총 3번)
//     halveCount(6) → 1   (6 → 3, 3은 홀수라서 멈춤)
//     halveCount(7) → 0
// 힌트: while (n % 2 == 0) { n /= 2; count++ }
fun halveCount(num: Int): Int {
    var n = num   // 파라미터는 val 이라 못 바꿔요. 그래서 var 에 복사!
    var count = 0

    while(n % 2 == 0) {
        n /= 2
        count++
    }

    return count
}

// [문제 4·보너스] step 과 until
// 0부터 n "미만"까지 2씩 건너뛴 짝수들의 합을 구하세요.
// 예: evenSum(10) → 0+2+4+6+8 = 20  (10은 미포함!)
// 힌트: for (i in 0 until n step 2)  ← until 은 끝값 미포함
fun evenSum(n: Int): Int {
    var total = 0

    for (i in 0 until n step 2) {
        total += i
    }

    return total
}

fun main() {
    println("sumTo(10) = ${sumTo(10)}")           // 기대 출력: 55
    println("sumTo(100) = ${sumTo(100)}")         // 기대 출력: 5050

    println("countdown(5) = ${countdown(5)}")     // 기대 출력: 5 4 3 2 1

    println("halveCount(8) = ${halveCount(8)}")   // 기대 출력: 3
    println("halveCount(6) = ${halveCount(6)}")   // 기대 출력: 1
    println("halveCount(7) = ${halveCount(7)}")   // 기대 출력: 0

    println("evenSum(10) = ${evenSum(10)}")       // 기대 출력: 20
}
