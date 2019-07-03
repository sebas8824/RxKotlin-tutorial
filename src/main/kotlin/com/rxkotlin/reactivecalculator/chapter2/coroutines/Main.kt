package com.rxkotlin.reactivecalculator.chapter2.coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async

fun main(args: Array<String>) {
    println("Initial output with a = 15, b = 10")
    var calculator: ReactiveCalculator =
        ReactiveCalculator(15, 10)
    println("Enter a = <number> or b = <number> in separate lines \nexit to exit the program")
    var line: String?
    do {
        line = readLine()
        /* suspend functions cannot be called on the main context, hence the async block */
        async(CommonPool) {
            calculator.handleInput(line)
        }
    } while (line != null && !line.toLowerCase().contains("exit"))
}