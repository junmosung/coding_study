package practice_by_agent

// A27. 제네릭 박스
// 목표: Box<T>.map → Box<R>. 캐스트 금지.
// 문법: generics, 타입 파라미터
// 규칙: transform 결과로 새 Box.
// 예: Box(10).map{it.toString()}.get()=="10"
// 금지: as Box<R> 캐스트
// 문서: docs/06_GENERICS_VARIANCE.md

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
