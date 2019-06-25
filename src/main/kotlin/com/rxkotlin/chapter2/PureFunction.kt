package com.rxkotlin.chapter2

/*
* Pure functions:
* The return value is completely dependent of its arguments or parameters
* Can be a lambda or a named function as well.
* Does not have side effects.
* */

fun square(n: Int): Int {
    return n*n
}

fun main(args: Array<String>) {
    println("Named pure function square = ${square(3)}")
    var qube = { n: Int -> n*n*n }
    print("Lambda pure function qube = ${qube(3)}")
}