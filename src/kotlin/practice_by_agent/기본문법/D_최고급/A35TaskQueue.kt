package practice_by_agent

// A35. 작업 큐
// 목표: put/take 스레드 안전. POISON으로 종료.
// 문법: synchronized+wait/notify 또는 BlockingQueue
// 규칙: 빈 큐 take는 대기.
// 예: A,B,C 소비 후 종료
// 금지: 바쁜 대기(busy loop)만
// 문서: docs/10_JAVA_INTEROP.md

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
