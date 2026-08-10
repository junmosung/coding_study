package pratice_by_agent

// A31. 지연 캐시
// HeavyReport는 compute 호출 횟수를 세고, report 프로퍼티는 by lazy로 한 번만 compute합니다.
// 조건: kotlin delegated property `by lazy`를 사용하세요.
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
