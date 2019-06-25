package com.rxkotlin.chapter2.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/*
* suspend: while executing the function the program should wait for its result
* */
suspend fun longRunningTsk(): Long {
    val time = measureTimeMillis {
        println("Please Wait")
        delay(2, TimeUnit.SECONDS)
        println("Delay Over")
    }
    return time
}

/* This program will block the thread until it completes */
fun main(args: Array<String>) {
    runBlocking {
        val exeTime = longRunningTsk()
        println("Execution time is $exeTime")
    }
}