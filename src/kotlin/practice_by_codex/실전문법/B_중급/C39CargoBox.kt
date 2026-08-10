package practice_by_codex

// C39. 범용 화물 상자
// 어떤 타입도 담을 수 있는 상자를 완성하세요.
// store는 기존 값을 교체하고, take는 값을 꺼낸 뒤 상자를 비웁니다.
class CargoBox<T> {
    private var item: T? = null

    val isEmpty: Boolean
        get() = true // TODO

    fun store(value: T) {
        // TODO
    }

    fun take(): T? {
        return null // TODO
    }
}

fun main() {
    val box = CargoBox<String>()
    check(box.isEmpty)
    box.store("sample")
    check(!box.isEmpty)
    check(box.take() == "sample")
    check(box.isEmpty)
    println("C39 통과")
}
