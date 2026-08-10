package practice_by_codex

sealed interface MissionState {
    data object Ready : MissionState
    data class Running(val progress: Int) : MissionState
    data object Completed : MissionState
    data class Failed(val reason: String) : MissionState
}

sealed interface MissionEventType {
    data object Start : MissionEventType
    data class Update(val progress: Int) : MissionEventType
    data object Complete : MissionEventType
    data class Fail(val reason: String) : MissionEventType
}

// C55. 임무 상태 머신
// 허용 전이: Ready+Start, Running+Update(0..100), Running+Complete, Running+Fail
// 그 외 조합은 Result.failure(IllegalStateException)로 반환하세요.
// 조건: state와 event를 다루는 완전한 when 흐름을 작성하세요.
fun transitionMission(state: MissionState, event: MissionEventType): Result<MissionState> {
    return Result.failure(NotImplementedError("TODO")) // TODO
}

fun main() {
    val running = transitionMission(MissionState.Ready, MissionEventType.Start).getOrThrow()
    check(running == MissionState.Running(0))
    check(transitionMission(running, MissionEventType.Update(50)).getOrNull() == MissionState.Running(50))
    check(transitionMission(MissionState.Running(50), MissionEventType.Complete).getOrNull() == MissionState.Completed)
    check(transitionMission(MissionState.Completed, MissionEventType.Start).isFailure)
    check(transitionMission(MissionState.Running(10), MissionEventType.Update(101)).isFailure)
    println("C55 통과")
}
