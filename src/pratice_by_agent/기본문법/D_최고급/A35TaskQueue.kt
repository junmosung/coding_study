package pratice_by_agent

// A35. 작업 큐 (생산자-소비자)
// SimpleTaskQueue는 스레드 안전하게 문자열 작업을 넣고(put) 꺼냅니다(take).
// take는 큐가 비어 있으면 작업이 들어올 때까지 대기해야 합니다.
// 종료를 위해 put(POISON) 후 소비자가 POISON을 만나면 중단하는 패턴을 사용하세요.
// 조건: synchronized + wait/notifyAll (또는 BlockingQueue) 중 하나로 구현하세요.
class SimpleTaskQueue {
    companion object {
        const val POISON = "__STOP__"
    }

    fun put(task: String) {
        // TODO
    }

    fun take(): String {
        return "" // TODO
    }
}

fun main() {
    val queue = SimpleTaskQueue()
    val consumed = mutableListOf<String>()

    val consumer = Thread {
        while (true) {
            val task = queue.take()
            if (task == SimpleTaskQueue.POISON) break
            consumed += task
        }
    }
    consumer.start()

    val producer = Thread {
        listOf("A", "B", "C").forEach { queue.put(it) }
        queue.put(SimpleTaskQueue.POISON)
    }
    producer.start()

    producer.join()
    consumer.join()

    check(consumed == listOf("A", "B", "C"))
    println("A35 통과")
}
