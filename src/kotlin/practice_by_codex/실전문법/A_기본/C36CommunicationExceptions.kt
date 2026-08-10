package practice_by_codex

class CommunicationTimeout : Exception()
class ChannelDisconnected : Exception()

// C36. 통신 예외 분류
// action 성공 -> "SUCCESS:결과"
// CommunicationTimeout -> "TIMEOUT", ChannelDisconnected -> "DISCONNECTED"
// 그 외 예외는 잡지 말고 호출자에게 전달하세요.
// 어떤 경로든 마지막에 onFinish를 정확히 한 번 호출합니다.
fun communicate(action: () -> String, onFinish: () -> Unit): String {
    return "" // TODO: try/catch/finally를 사용하세요
}

fun main() {
    var finished = 0
    check(communicate({ "OK" }, { finished++ }) == "SUCCESS:OK")
    check(communicate({ throw CommunicationTimeout() }, { finished++ }) == "TIMEOUT")
    check(communicate({ throw ChannelDisconnected() }, { finished++ }) == "DISCONNECTED")
    check(finished == 3)
    println("C36 통과")
}
