package com.rxkotlin.chapter2.coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.async

/* Unlike Starter, this program will execute in another thread (common)
* Coroutine contexts:
* 1. Unconfined: It will run on the main thread
* 2. CommonPool: runs on the common thread pool
* 3. A new coroutine can be created as well
* */
fun main(args: Array<String>) {
    val time = async(CommonPool) { longRunningTsk() }
    println("Print after async ")
    runBlocking { println("printing time ${time.await()}") }
}