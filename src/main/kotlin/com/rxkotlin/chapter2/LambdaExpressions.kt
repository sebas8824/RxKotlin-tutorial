package com.rxkotlin.chapter2

import java.util.*

/*
* Lambda Expression:
* Is also considered an Anonymous function.
* Is a function but a function not always is a Lambda expression.
*/

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    println("Sum ${sum(12, 14)}")
    val anonymousMult = {
        x: Int -> (Random().nextInt(15)+1) * x
    }
    println("Random output ${anonymousMult(2)}")
}