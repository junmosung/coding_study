package pratice_by_codex

// C21. 승무원 등급
// 각 등급은 accessLevel을 가집니다: ROOKIE=1, EXPERT=2, COMMANDER=3.
// canAccess(requiredLevel)는 자신의 권한이 요구 권한 이상일 때 true를 반환합니다.
// 조건: enum 생성자 프로퍼티와 enum 내부 메서드를 사용하세요.
enum class CrewRank(val accessLevel: Int) {
    ROOKIE(1),
    EXPERT(2),
    COMMANDER(3);

    fun canAccess(requiredLevel: Int): Boolean {
        return false // TODO
    }
}

fun main() {
    check(CrewRank.COMMANDER.canAccess(3))
    check(CrewRank.EXPERT.canAccess(1))
    check(!CrewRank.ROOKIE.canAccess(2))
    println("C21 통과")
}
