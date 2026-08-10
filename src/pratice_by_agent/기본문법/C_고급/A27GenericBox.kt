package pratice_by_agent

// A27. 제네릭 박스
// Box<T>는 value를 보관하고 get()으로 꺼냅니다.
// map(transform)은 변환된 값을 담은 새 Box<R>를 반환합니다.
class Box<T>(private val value: T) {
    fun get(): T = value // 구현됨

    fun <R> map(transform: (T) -> R): Box<R> {
        TODO("transform으로 새 Box를 만들어 반환하세요")
    }
}

fun main() {
    val box = Box(10)
    check(box.get() == 10)
    check(box.map { it.toString() }.get() == "10")
    check(box.map { it * 2 }.get() == 20)
    println("A27 통과")
}
