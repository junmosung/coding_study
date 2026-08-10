package practice_by_codex

interface ItemRepository {
    fun save(value: String)
    fun findAll(): List<String>
}

class MemoryItemRepository : ItemRepository {
    private val values = mutableListOf<String>()
    override fun save(value: String) { values += value }
    override fun findAll(): List<String> = values.toList()
}

// C47. 저장소 기능 위임
// 모든 기능은 delegate에 위임하되 save 호출 횟수만 기록하세요.
class CountingItemRepository(
    private val delegate: ItemRepository,
) : ItemRepository by delegate {
    var saveCount: Int = 0
        private set

    override fun save(value: String) {
        // TODO: 횟수를 올리고 delegate에 저장
    }
}

fun main() {
    val repository = CountingItemRepository(MemoryItemRepository())
    repository.save("A")
    repository.save("B")
    check(repository.saveCount == 2)
    check(repository.findAll() == listOf("A", "B"))
    println("C47 통과")
}
