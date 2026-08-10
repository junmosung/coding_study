package pratice_by_agent

import java.util.concurrent.Callable
import java.util.concurrent.Executors

// B24. Future 결과 수집
// raw 문자열들을 스레드 풀에서 Int로 파싱하고, 성공한 값만 모은 리스트를 반환하세요.
// 파싱 실패는 건너뛰세요.
// 조건: ExecutorService.submit 또는 invokeAll과 Future를 사용하세요.
fun parseAllAsync(rawValues: List<String>, poolSize: Int = 2): List<Int> {
    return emptyList() // TODO
}

fun main() {
    val result = parseAllAsync(listOf("1", "x", "3", "2"), poolSize = 2).sorted()
    check(result == listOf(1, 2, 3))
    check(parseAllAsync(emptyList()) == emptyList<Int>())
    println("B24 통과")
}
