package com.rxkotlin.chapter3.observables.just

import com.rxkotlin.chapter3.observables.Chapter3Utils
import io.reactivex.Observable

/*
* Observable.just:
* Is a factory method that creates an Observable and adds the parameters passed to it
* Note that its parameters are the items of the Observable regardless if the first item is an iterable structure.
* */

fun main(args: Array<String>) {
    val observer = Chapter3Utils.createObserver()
    /* Single item */
    Observable.just("A String").subscribe(observer)
    Observable.just(88).subscribe(observer)
    Observable.just(listOf("String 1", "String 2", 3)).subscribe(observer)
    /* Single item */
    Observable.just(mapOf(Pair("Key 1", "Value 1"), Pair("Key 2", "Value 2"), Pair("Key 3", "Value 3"))).subscribe(observer)
    Observable.just(arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)).subscribe(observer)
    /* Multiple items */
    Observable.just("A lone value 1", "Another value 2", "This is the last value 3").subscribe(observer)
}