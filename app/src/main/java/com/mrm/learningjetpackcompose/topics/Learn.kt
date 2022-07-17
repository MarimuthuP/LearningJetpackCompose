package com.mrm.learningjetpackcompose.topics

fun main() {
    val circle = Shape.Circle(5.0f)
    var rectangle = Shape.Rectangle(20, 40)
    var square = Shape.Square(15)

    checkShape(circle)
}

fun checkShape(shape: Shape) {
    when (shape) {
        is Shape.Circle -> println("Circle area is ${3.14 * shape.radius * shape.radius}")
        is Shape.Rectangle -> println("Rectangle area is ${shape.length * shape.breadth}")
        is Shape.Square -> println("Square area is ${shape.side * shape.side}")
        Shape.NoShape -> println("No shape Found")
    }
}

sealed class Shape {
    data class Circle(val radius: Float) : Shape()
    class Rectangle(val length: Int, val breadth: Int) : Shape()
    class Square(val side: Int) : Shape()
    object NoShape: Shape()
}