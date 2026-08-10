package practice_by_claude

// ─────────────────────────────────────────────
// 코틀린 입문 연습 7회차: 람다와 컬렉션 함수
// 핵심: for 문 대신 "무엇을 할지"만 넘기는 스타일!
//   list.filter { it > 3 }     ← 조건에 맞는 것만 남김
//   list.map { it * 2 }        ← 각 항목을 변환
//   list.count { it > 3 }      ← 조건에 맞는 개수
//   it = 항목 하나를 가리키는 자동 이름
// ─────────────────────────────────────────────

// [문제 1] filter
// 정수 리스트에서 짝수만 골라 돌려주세요.
// 예: evens(listOf(1, 2, 3, 4, 5, 6)) → [2, 4, 6]
// 힌트: numbers.filter { it % 2 == 0 }
fun evens(numbers: List<Int>): List<Int> {
    return listOf() // TODO: 표현식 본문(=)으로 바꿔도 좋아요
}

// [문제 2] map
// 이름 리스트를 "이름님" 형태로 변환해 돌려주세요.
// 예: honorifics(listOf("철수", "영희")) → [철수님, 영희님]
// 힌트: names.map { "${it}님" }
fun honorifics(names: List<String>): List<String> {
    return listOf() // TODO
}

// [문제 3] 체이닝 (연결해서 쓰기)
// 정수 리스트에서 "3보다 큰 수들만" 골라 "제곱한" 리스트를 돌려주세요.
// 예: bigSquares(listOf(1, 2, 3, 4, 5)) → [16, 25]
// 힌트: filter 결과에 바로 .map 을 이어 붙일 수 있어요!
fun bigSquares(numbers: List<Int>): List<Int> {
    return listOf() // TODO
}

// [문제 4] 데이터 클래스와 조합 (실전 스타일!)
// 6회차의 User(name, email)를 재사용합니다.
// 유저 리스트에서 이메일이 "@kotlin.dev" 로 끝나는 유저들의
// "이름"만 뽑아 돌려주세요.
// 예: kotlinUserNames(listOf(
//        User("빅터", "v@kotlin.dev"),
//        User("철수", "c@gmail.com"),
//        User("영희", "y@kotlin.dev")
//     )) → [빅터, 영희]
// 힌트: filter { it.email.endsWith("@kotlin.dev") } 그리고 map { it.name }
fun kotlinUserNames(users: List<User>): List<String> {
    return listOf() // TODO
}

// [문제 5·보너스] 종합
// 정수 리스트에서 "음수를 제외한" 수들의 "합"을 구하세요.
// 이번엔 for 문 금지! 컬렉션 함수만으로 풀어보세요.
// 예: positiveSum(listOf(3, -1, 5, -2, 4)) → 12
// 힌트: filter 와 sum() 조합. 또는 sumOf 를 찾아봐도 좋아요.
fun positiveSum(numbers: List<Int>): Int {
    return 0 // TODO
}

fun main() {
    println(evens(listOf(1, 2, 3, 4, 5, 6)))       // 기대: [2, 4, 6]
    println(honorifics(listOf("철수", "영희")))      // 기대: [철수님, 영희님]
    println(bigSquares(listOf(1, 2, 3, 4, 5)))      // 기대: [16, 25]

    val users = listOf(
        User("빅터", "v@kotlin.dev"),
        User("철수", "c@gmail.com"),
        User("영희", "y@kotlin.dev"),
    )
    println(kotlinUserNames(users))                  // 기대: [빅터, 영희]

    println(positiveSum(listOf(3, -1, 5, -2, 4)))    // 기대: 12
}
