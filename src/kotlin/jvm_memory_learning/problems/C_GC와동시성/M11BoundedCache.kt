package jvm_memory_learning.problems.m11

// M11. 제한된 cache
// insertion order 기준으로 가장 오래된 entry를 제거해 최대 maxSize만 유지하세요.
// maxSize는 1 이상이어야 합니다.
class BoundedMemoryCache<K, V>(private val maxSize: Int) {
    private val values = linkedMapOf<K, V>()

    init {
        require(maxSize > 0)
    }

    fun put(key: K, value: V) {
        // TODO
    }

    fun get(key: K): V? = values[key]

    fun keys(): List<K> = values.keys.toList()
}

fun main() {
    val cache = BoundedMemoryCache<String, ByteArray>(2)
    cache.put("A", ByteArray(8))
    cache.put("B", ByteArray(8))
    cache.put("C", ByteArray(8))

    check(cache.get("A") == null)
    check(cache.keys() == listOf("B", "C"))
    check(cache.get("C")?.size == 8)
    println("M11 통과")
}
