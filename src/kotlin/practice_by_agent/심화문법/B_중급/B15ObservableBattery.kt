package practice_by_agent

// B15. 배터리 관측
// 목표: 0..100만 set, 변경 시 콜백. 범위밖 무시.
// 문법: ReadWriteProperty
// 규칙: 예외 대신 무시 정책.
// 예: 50→80→200무시→10, changes 두 번
// 금지: 범위밖에서 예외(정책과 불일치)
// 문서: docs/07_EXTENSIONS_SCOPE_DELEGATION.md

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ObservableBattery(
    initial: Int,
    private val onChange: (old: Int, new: Int) -> Unit,
) : ReadWriteProperty<Any?, Int> {
    private var value: Int = initial

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int = value

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        // TODO
    }
}

class BatteryPack {
    val changes = mutableListOf<Pair<Int, Int>>()
    var battery: Int by ObservableBattery(50) { old, new ->
        changes += old to new
    }
}

fun main() {
    val pack = BatteryPack()
    pack.battery = 80
    pack.battery = 200 // 무시
    pack.battery = 10
    check(pack.battery == 10)
    check(pack.changes == listOf(50 to 80, 80 to 10))
    println("B15 통과")
}
