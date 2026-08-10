data class Point(val x: Int, val y: Int)

fun main() {
//    // 1. 숫자 2배
//    println(listOf(1, 2, 3).map { it * 2 })                       // [2, 4, 6]
//
//    // 2. 타입 변환 (String → Int)
//    println(listOf("10", "20", "30").map(String::toInt))          // [10, 20, 30]
//
//    // 3. 객체에서 값 추출
//    val users = listOf(User("Kim", 20), User("Lee", 30))
//    println(users.map { it.name })                                // [Kim, Lee]
//    println(users.map(User::age))                                 // [20, 30]
//
//    // 4. map으로 시작해 체인
//    println(
//        listOf("1", "-2", "3", "-4")
//            .map { it.toInt() }
//            .filter { it > 0 }
//            .map { it * 10 }                                       // [10, 30]
//    )
//
//    // 5. 문자열 → 객체 파싱
//    val points = listOf("1,2", "3,4").map { line ->
//        val (x, y) = line.split(",")
//        Point(x.toInt(), y.toInt())
//    }
//    println(points)                                               // [Point(x=1, y=2), Point(x=3, y=4)]
//
//    // 6. 인덱스 포함
//    println(listOf("a", "b", "c").mapIndexed { i, v -> "$i:$v" }) // [0:a, 1:b, 2:c]
//
//    // 7. map 후 합계
//    println(listOf("10", "20", "30").map { it.toInt() }.sum())    // 60
}
