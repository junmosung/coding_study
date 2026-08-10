package practice_by_agent

// B12. 쓰기 적재함
// 목표: Loader<in Loadable>에 Box/Tube load.
// 문법: in 변성
// 규칙: loadSample이 Loader<Loadable>에 적재.
// 예: size()==2
// 금지: 꺼내기 API를 쓰기 전용에 추가
// 문서: docs/06_GENERICS_VARIANCE.md

sealed interface Loadable

data class BoxLoad(val id: String) : Loadable
data class TubeLoad(val id: String) : Loadable

class Loader<in T : Loadable> {
    private val items = mutableListOf<T>()

    fun load(item: T) {
        // TODO
    }

    fun size(): Int = items.size
}

fun loadSample(loader: Loader<Loadable>) {
    // TODO: BoxLoad와 TubeLoad를 각각 load 하세요
}

fun main() {
    val loader = Loader<Loadable>()
    loadSample(loader)
    check(loader.size() == 2)
    println("B12 통과")
}
