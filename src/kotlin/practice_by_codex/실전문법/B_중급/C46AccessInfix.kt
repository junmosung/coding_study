package practice_by_codex

enum class AccessRank(val level: Int) { ROOKIE(1), EXPERT(2), COMMANDER(3) }
data class ProtectedResource(val requiredLevel: Int)

// C46. 권한 중위 표현
// rank의 level이 자원의 requiredLevel 이상이면 true를 반환하세요.
infix fun AccessRank.canAccess(resource: ProtectedResource): Boolean {
    return false // TODO
}

fun main() {
    val restricted = ProtectedResource(requiredLevel = 2)
    check(AccessRank.COMMANDER canAccess restricted)
    check(AccessRank.EXPERT canAccess restricted)
    check(!(AccessRank.ROOKIE canAccess restricted))
    println("C46 통과")
}
