package pratice_by_codex

enum class MissionStatus { READY, RUNNING, DONE }

data class MissionLog(val id: Int, val status: MissionStatus, val memo: String)

// C20. 임무 기록
// 원본 MissionLog는 변경하지 않고 status만 DONE으로 바꾼 새 객체를 반환하세요.
// id와 memo는 원본 값을 유지해야 합니다.
// 조건: data class의 copy를 사용하세요.
fun completeMission(log: MissionLog): MissionLog {
    return log // TODO
}

fun main() {
    val original = MissionLog(7, MissionStatus.RUNNING, "crater scan")
    val completed = completeMission(original)
    check(completed == MissionLog(7, MissionStatus.DONE, "crater scan"))
    check(original.status == MissionStatus.RUNNING)
    check(original !== completed)
    println("C20 통과")
}
