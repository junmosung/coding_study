package practice_by_codex

import java.io.Closeable

class CommunicationChannel(
    private val message: String,
    private val onClose: () -> Unit,
) : Closeable {
    fun read(): String = message
    override fun close() = onClose()
}

// C53. 리소스 자동 해제
// opener가 만든 채널의 메시지를 읽어 반환하세요.
// 성공하거나 read가 실패해도 close가 한 번 호출되어야 합니다.
// 조건: try/finally 대신 use를 사용하세요.
fun readChannel(opener: () -> CommunicationChannel): String {
    return "" // TODO
}

fun main() {
    var closes = 0
    check(readChannel { CommunicationChannel("signal") { closes++ } } == "signal")
    check(closes == 1)
    println("C53 통과")
}
