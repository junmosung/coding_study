package pratice_by_agent

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// B15. 배터리 관측 위임
// 0..100 범위만 허용하고, 값이 바뀔 때 onChange(old, new)를 호출하세요.
// 범위 밖 set은 무시하세요. (예외를 던지지 않음)
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
