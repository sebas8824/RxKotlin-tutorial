package com.rxkotlin.chapter2

/*
* High Order Function:
* Take another function as an argument or return a function as a result
* */

fun highOrderFunction(a: Int, validityCheckFunc: (a: Int) -> Boolean) {
    if(validityCheckFunc(a)) {
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}

fun Int.isEven(): Boolean = ((this % 2) == 0)

fun main(args: Array<String>) {
    highOrderFunction(12, { a: Int -> a.isEven() })
    highOrderFunction(19, { a: Int -> a.isEven()})
}