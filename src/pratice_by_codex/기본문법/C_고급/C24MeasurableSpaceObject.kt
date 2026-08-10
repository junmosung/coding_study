package pratice_by_codex

import kotlin.math.PI

// C24. 측정 가능한 우주 물체
// 모든 물체는 질량을 계산하는 mass()를 제공합니다.
abstract class MeasurableSpaceObject {
    abstract fun mass(): Double
}

// 구형 물체의 질량 = (4 / 3) * PI * radius^3 * density
class SphericalObject(private val radius: Double, private val density: Double) : MeasurableSpaceObject() {
    override fun mass(): Double {
        return 0.0 // TODO
    }
}

// 상자형 물체의 질량 = width * height * depth * density
class BoxObject(
    private val width: Double,
    private val height: Double,
    private val depth: Double,
    private val density: Double,
) : MeasurableSpaceObject() {
    override fun mass(): Double {
        return 0.0 // TODO
    }
}

fun main() {
    check(kotlin.math.abs(SphericalObject(1.0, 3.0).mass() - 4.0 * PI) < 0.000001)
    check(BoxObject(2.0, 3.0, 4.0, 5.0).mass() == 120.0)
    println("C24 통과")
}
