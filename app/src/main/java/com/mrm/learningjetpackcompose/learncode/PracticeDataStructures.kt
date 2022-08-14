package com.mrm.learningjetpackcompose.learncode

import kotlin.properties.Delegates.notNull

fun main() {
    val list = ArrayList<Name>()
    list.add(Name("Sachin", "Tendulkar"))
    list.add(Name("Rahul", "Dravid"))
    list.add(Name("Sanju", "Samson"))
    list.add(Name("Ravindra", "Jadeja"))
    list.add(Name("Virat", "Kohli"))
    list.add(Name("MS", "Dhoni"))

    println("The list is")
    println(list)

    val comparatorOne = ComparatorOne()
    list.sortedWith(comparatorOne)
    println("List sorted according to first Name")
    println(list)

    val anotherComparator = AnotherComparator()
    val finalComparator = comparatorOne.then(anotherComparator)
    list.sortedWith(finalComparator)
    println("List sorted according to first name and last name")
    println(list)
}

class Name(val firstName: String, val lastName: String) {
    override fun toString(): String {
        return "$firstName $lastName"
    }
}

class ComparatorOne : Comparator<Name> {
    override fun compare(o1: Name?, o2: Name?): Int {
        if (o1 == null || o2 == null) {
            return 0
        }
        return o1.firstName.compareTo(o2.lastName)
    }
}

class AnotherComparator: Comparator<Name> {
    override fun compare(o1: Name?, o2: Name?): Int {
        if(o1==null || o2==null){
            return 0
        }
        return o1.lastName.compareTo(o2.lastName)
    }

}