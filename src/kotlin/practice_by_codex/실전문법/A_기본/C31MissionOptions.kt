package practice_by_codex

data class MissionOptions(
    val destination: String,
    val retries: Int,
    val safeMode: Boolean,
)

// C31. 탐사 옵션 생성
// 기본값은 retries=3, safeMode=true입니다.
// 조건: 기본 인수를 선언하고 전달받은 값을 그대로 데이터 클래스에 담으세요.
fun createOptions(
    destination: String,
    retries: Int = 3,
    safeMode: Boolean = true,
): MissionOptions {
    return MissionOptions("", 0, false) // TODO
}

fun main() {
    check(createOptions("Mars") == MissionOptions("Mars", 3, true))
    check(createOptions("Moon", safeMode = false) == MissionOptions("Moon", 3, false))
    check(createOptions(destination = "Venus", retries = 5) == MissionOptions("Venus", 5, true))
    println("C31 통과")
}
