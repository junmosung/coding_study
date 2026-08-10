package practice_by_codex

class LaunchSystem(private var fuel: Int) {
    // C34. 발사 조건 검증
    // payloadKg가 양수가 아니면 require로 거절하세요.
    // fuel이 payloadKg보다 적으면 check로 상태 오류를 발생시키세요.
    // 성공하면 연료를 차감하고 남은 연료를 반환합니다.
    fun prepare(payloadKg: Int): Int {
        return fuel // TODO
    }
}

fun main() {
    val system = LaunchSystem(100)
    check(system.prepare(40) == 60)
    check(runCatching { system.prepare(0) }.exceptionOrNull() is IllegalArgumentException)
    check(runCatching { system.prepare(70) }.exceptionOrNull() is IllegalStateException)
    println("C34 통과")
}
