package com.rxkotlin.chapter3.observables.other

import com.rxkotlin.chapter3.observables.Chapter3Utils
import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observer = Chapter3Utils.createObserver()

    /*
    * Observable.range:
    * Creates an Observable and emits integers with the supplied start parameter, finishing to count value
    * */
    Observable.range(1, 10).subscribe(observer)
    /*
    * Observable.empty:
    * Creates an Observable and emits onComplete without emitting any items with onNext()
    * */
    Observable.empty<String>().subscribe(observer)

    runBlocking {
        /*
        * Observable.interval:
        * Emits numbers sequentially starting from 0, after each specified interval.
        * It will continue emitting until you unsuscribe and until the program runs.
        * In this case it will emit a number each 333 milliseconds for the next 10 seconds counting up to 30
        * */
        Observable.interval(333, TimeUnit.MILLISECONDS).subscribe(observer)
        delay(10000)
        /*
        * Observable.timer:
        * It will emit 0 after the specified time elapses
        * */
        Observable.timer(400, TimeUnit.MILLISECONDS).subscribe(observer)
        delay(450)
    }
}