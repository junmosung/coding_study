package pratice_by_agent

// B12. 쓰기 전용 적재함 (반공변 in)
// Loadable 계층과 Loader<in T>를 만드세요.
// load(item)만 가능하고, Loader<Loadable>에 BoxLoad를 넣을 수 있어야 합니다.
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
