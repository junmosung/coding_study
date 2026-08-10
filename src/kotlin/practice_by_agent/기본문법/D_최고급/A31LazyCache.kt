package practice_by_agent

// A31. 지연 캐시
// 목표: report는 by lazy로 compute 1회만.
// 문법: by lazy
// 규칙: 접근 전 computeCount==0.
// 예: 두 번 읽어도 computeCount==1
// 금지: 초기화 블록에서 즉시 계산
// 문서: docs/07_EXTENSIONS_SCOPE_DELEGATION.md

class HeavyReport(private val seed: Int) {
    var computeCount: Int = 0
        private set

    private fun compute(): Int {
        computeCount += 1
        return seed * 10
    }

    val report: Int by lazy {
        0 // TODO: compute() 결과를 lazy로 반환
    }
}

fun main() {
    val heavy = HeavyReport(7)
    check(heavy.computeCount == 0)
    check(heavy.report == 70)
    check(heavy.report == 70)
    check(heavy.computeCount == 1)
    println("A31 통과")
}
