package com.rxkotlin.chapter3.observables.toObservable

import com.rxkotlin.chapter3.observables.Chapter3Utils
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

/*
* toObservable:
* It is an extension function that can turn any Iterable instance to an Observable without
* much effort
* */

fun main(args: Array<String>) {
    val observer = Chapter3Utils.createObserver()
    val list: List<String> = listOf("String 1", "String 2", "String 3", "String 4")
    val observable: Observable<String> = list.toObservable()
    observable.subscribe(observer)
}