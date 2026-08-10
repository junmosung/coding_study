package practice_by_agent

// A26. 측정 화물
// 목표: Box=w*h*d, Cylinder=PI*r*r*h.
// 문법: abstract class, override
// 규칙: 실수 연산 사용.
// 예: Box(2,3,4).volume()==24.0
// 금지: 정수 나눗셈으로 부피 계산
// 문서: docs/04_TYPE_MODELING.md

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
