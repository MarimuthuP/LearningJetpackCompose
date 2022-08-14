package com.mrm.learningjetpackcompose


// Map
// it is a collection which contains pairs of objects,
// Map holds the data in the form of pairs which consists of a key and a value
// Map keys are unique and the map holds only one value for each key

fun main() {
    simpleMap()
    usingZip()
    libFunction()
    swapMethod()
}

fun swapMethod() {
    val list = mutableListOf(6,9,7)
    println("Orig list - $list")
    val result = list.swap(0,2) //MutableList class does not support the swap() internally.
    println("After swapping list - $result")
}

private fun MutableList<Int>?.swap(first: Int, second: Int): Any {
    if(this==null) return "null"
    else{
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
        return this
    }
}

fun libFunction() {
    //Runtime exception
    /*fun Int.abs(): Int{
        return if(this < 0)
    }
    println((-4).abs())
    println(4.abs())*/
}

fun usingZip() {
    val colors = listOf("red", "green", "yellow")
    val animals = listOf("bear","lion", "tiger")
    println(colors zip animals)

    val twoAnimals = listOf("fox","dog")
    println(twoAnimals.zip(colors))
}

fun simpleMap() {
    val numbers = listOf(1, 2, 3)
    println(numbers.map { it * it })
}
