package pratice_by_agent

// A26. 측정 가능 화물
// 추상 클래스 Cargo에 abstract fun volume(): Double 을 정의하세요.
// BoxCargo(w,h,d) = w*h*d
// CylinderCargo(r,h) = PI * r * r * h  (kotlin.math.PI 사용)
abstract class Cargo {
    abstract fun volume(): Double
}

class BoxCargo(val w: Double, val h: Double, val d: Double) : Cargo() {
    override fun volume(): Double = 0.0 // TODO
}

class CylinderCargo(val r: Double, val h: Double) : Cargo() {
    override fun volume(): Double = 0.0 // TODO
}

fun main() {
    check(BoxCargo(2.0, 3.0, 4.0).volume() == 24.0)
    val cyl = CylinderCargo(1.0, 2.0).volume()
    check(kotlin.math.abs(cyl - (kotlin.math.PI * 2.0)) < 1e-9)
    println("A26 통과")
}
