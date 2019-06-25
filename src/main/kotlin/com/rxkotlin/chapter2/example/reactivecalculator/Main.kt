package com.rxkotlin.chapter2.example.reactivecalculator

fun main(args: Array<String>) {
    println("Initial output with a = 15, b = 10")
    var calculator: ReactiveCalculator =
        ReactiveCalculator(15, 10)
    println("Enter a = <number> or b = <number> in separate lines \nexit to exit the program")
    var line: String?
    do {
        line = readLine()
        calculator.handleInput(line)
    } while (line != null && !line.toLowerCase().contains("exit"))
}