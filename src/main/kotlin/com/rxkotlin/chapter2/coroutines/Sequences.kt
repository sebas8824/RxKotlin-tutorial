package com.rxkotlin.chapter2.coroutines

import kotlin.coroutines.experimental.buildSequence

/* Sequence:
* Represents lazily evaluated collections
* yield(): Related to return a state and when called again, starts from there
* */

fun main(args: Array<String>) {
    val fibonacciSeries = buildSequence {
        var a = 0
        var b = 1
        yield(a)
        yield(b)

        while(true) {
            val c = a+b
            yield(c)
            a=b
            b=c
        }
    }

    println(fibonacciSeries.take(10).toList())
}
