package com.mrm.learningjetpackcompose

fun main(args: Array<String>) {
    /*checkPalinPrimeNumbers()
    checkReverseNumber()
    checkRemainder()*/

    //checkArmstrongNumber()
    //checkArmstrongNumberBetweenTwoNumbers()
    findTotalUnclosedBrackets()

    //region Finding output from this snippet
    /*findOutputFromThisPart1()
    findOutputFromThisPart2()*/
    //endregion
}

private fun findTotalUnclosedBrackets() {
    val inputString = "()))(("
    val inputSize = inputString.length
    var isOpened = 0
    var isClosed = 0
    var isItCorrect = 0

    var inputChars = inputString.toCharArray()
    for (i in 0 until inputSize){

        if(inputChars[i]==')' || inputChars[i]==']' || inputChars[i]=='}'){
            break
        }

        if(inputChars[i] =='('){
            isOpened++
            isItCorrect++
            continue
        }
        if(inputChars[i] ==')'){
            isClosed++
            isItCorrect--
            continue
        }
    }

    println("Total opened: $isOpened and closed: $isClosed")
    if(isOpened==isClosed && isItCorrect==0){
        println("Yes perfect string")
    } else {
        println("Not a perfect string")
    }
}

fun checkArmstrongNumber() {
    println("Enter the number to find Armstrong number")
    val input = readLine()!!.toInt()
    var remainder = 0
    var result = 0

    var originalNumber: Int = input

    while (originalNumber != 0) {
        remainder = originalNumber % 10
        //result += (remainder * remainder * remainder) Instead of this we can use as below
        result += Math.pow(remainder.toDouble(), 3.0).toInt()
        originalNumber /= 10
    }

    if (result == input)
        println("$input is an armstrong number")
    else
        println("$input is not an armstrong number")
}

fun checkArmstrongNumberBetweenTwoNumbers(){
    val totalInput = readLine()!!.toInt()
    for (i in 1..totalInput){
        val limit = readLine()!!.split(' ')
        val startNumber = limit[0].toInt()
        val endNumber = limit[1].toInt()
        val totalArmstrongNumber = findTotalArmstrong(startNumber, endNumber)
        println("Total Armstrong no: $totalArmstrongNumber")
    }
}

fun findTotalArmstrong(startNumber: Int, endNumber: Int): Any {
    var start = startNumber
    var end = endNumber
    var count = 0

    for (number in start..end){
        var digits = 0
        var origNumber = number
        var remainder = 0
        var result = 0

        while (origNumber!=0){
            origNumber /= 10
            digits++
        }

        origNumber = number

        if(digits>=2){
            while (origNumber!=0){
                remainder = origNumber%10
                result += Math.pow(remainder.toDouble(), digits.toDouble()).toInt()
                origNumber /= 10
            }

            if(result==number){
                count++
                println("----> $number")
            }
        }
    }
    return count
}

private fun findOutputFromThisPart2() {
    val c = mutableListOf("a", "b")
    val d: List<*> = c as List<*>
    print("d = $d")
    c.removeAt(0)
    print("d = $d")
}

private fun findOutputFromThisPart1() {
    val a = listOf(1, 2, 3).fold(0) { one, two -> one + two }
    println("VALUEEEE -> $a")
    val num: Int = 8
    println(num)
}

private fun checkPalinPrimeNumbers() {
    println("Enter the number limit: ")
    val input = readLine()!!.toInt()
    println("Enter the number and tap space and enter another number: ")
    for (i in 1..input) {
        val limit = readLine()!!.split(' ')
        val l = limit[0].toInt()
        val r = limit[1].toInt()
        val out_: Int = palPrime(l, r)
        println(out_)
    }
}

/**
 * This method is used to find the Prime Palindrome numbers
 */
fun palPrime(L: Int, R: Int): Int {
    var fromNum = L
    var toNum = R
    var palPrimeCount = 0
    while (fromNum <= toNum) {
        if (checkPrimeNumber(fromNum)) {
            if (checkPalinNumber(fromNum)) {
                println("yes PalinPrime ----->: $fromNum")
                palPrimeCount++
            }
        }
        fromNum++
    }
    return palPrimeCount
}

/**
 * This method is used to find whether the given number is prime or not.
 */
fun checkPrimeNumber(number: Int): Boolean {
    var flag = true
    for (i in 2..(number / 2)) {
        if (number % 2 == 0) {
            flag = false
            break
        }
    }
    return flag
}

/**
 * This method is used to find whether the given number is meet the palindrome format.
 */
fun checkPalinNumber(num: Int): Boolean {
    var input = num
    var origNum = num
    var remainder = 0
    var reverseNum = 0

    while (input != 0) {
        remainder = input % 10
        reverseNum = reverseNum * 10 + remainder
        input /= 10
    }
    return (origNum == reverseNum)
}

/**
 * This method is used to find the quotient and remainder based on given inputs.
 */
fun checkRemainder() {
    println("Enter the dividend and divisor: ")
    val dividend = readLine()!!.toInt()
    val divisor = readLine()!!.toInt()

    val quotient = dividend / divisor
    val remainder = dividend % divisor

    println("Quotient = $quotient")
    println("Remainder = $remainder")
}

/**
 * This method is used to reverse the number.
 */
fun checkReverseNumber() {
    println("Enter the number to find Reverse number")
    val input = readLine()!!.toInt()

    var number = input
    var remainder: Int
    var reverseNum = 0

    while (number != 0) {
        remainder = number % 10
        reverseNum = reverseNum * 10 + remainder
        number /= 10
    }
    println("Reverse no: $reverseNum")
}
