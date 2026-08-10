package practice_by_claude

// ─────────────────────────────────────────────
// 코틀린 입문 연습 4회차: 컬렉션 기초 (List / MutableList)
// 핵심: 코틀린 컬렉션은 "읽기 전용"과 "수정 가능"이 타입부터 다릅니다!
//   listOf(1, 2, 3)        → List<Int>        (읽기 전용)
//   mutableListOf(1, 2, 3) → MutableList<Int> (추가/삭제 가능)
// ─────────────────────────────────────────────

// [문제 1] 리스트 만들기와 순회
// 문자열 리스트를 받아 각 항목을 "- 항목" 형태로 한 줄씩 출력하는 함수.
// 예: printMenu(listOf("김밥", "라면")) 출력:
//   - 김밥
//   - 라면
// 힌트: for (item in list) { ... }
fun printMenu(menu: List<String>) {
    for (c in menu) {
        println("- $c")
    }
}

// [문제 2] 인덱스와 함께 순회
// 리스트를 받아 "1위: 항목" 형태로 순위를 붙여 출력하는 함수.
// 예: printRanking(listOf("코틀린", "자바")) 출력:
//   1위: 코틀린
//   2위: 자바
// 힌트: for ((index, item) in list.withIndex()) { ... }
//       index 는 0부터 시작하니 +1 필요!
fun printRanking(items: List<String>) {
    for ((index, item) in items.withIndex()) {
        println("${index+1}위: $item")
    }
}

// [문제 3] MutableList 조작
// 빈 MutableList 를 만들어서:
//   1) "사과", "바나나", "체리" 를 순서대로 추가(add)하고
//   2) "바나나" 를 제거(remove)한 뒤
//   3) 그 리스트를 돌려주세요.
// 힌트: val list = mutableListOf<String>()  ← 빈 리스트는 타입 <String> 명시 필요
fun makeFruits(): MutableList<String> {
    val mutableListOf = mutableListOf<String>()

    mutableListOf.add("사과")
    mutableListOf.add("바나나")
    mutableListOf.add("체리")
    mutableListOf.removeAt(1)

    return mutableListOf
}

// [문제 4] 리스트 집계
// 정수 리스트에서 최댓값과 최솟값의 차이를 돌려주는 함수.
// 예: rangeOf(listOf(3, 8, 1, 6)) → 7  (8 - 1)
// 힌트: list.max() 와 list.min() 이 이미 있어요!
fun rangeOf(numbers: List<Int>): Int {
    return numbers.max() - numbers.min()
}

fun main() {
    printMenu(listOf("김밥", "라면", "떡볶이"))
    // 기대 출력:
    // - 김밥
    // - 라면
    // - 떡볶이

    println()
    printRanking(listOf("코틀린", "자바", "파이썬"))
    // 기대 출력:
    // 1위: 코틀린
    // 2위: 자바
    // 3위: 파이썬

    println()
    println("makeFruits() = ${makeFruits()}")   // 기대 출력: [사과, 체리]
    println("rangeOf = ${rangeOf(listOf(3, 8, 1, 6))}")  // 기대 출력: 7
}
