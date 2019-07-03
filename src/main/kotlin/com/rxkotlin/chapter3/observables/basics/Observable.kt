package com.rxkotlin.chapter3.observables.basics

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observer: Observer<Any> = object: Observer<Any> {
        override fun onComplete() {
            println("All completed")
        }

        override fun onError(e: Throwable) {
            println("Error occured $e")
        }

        override fun onNext(t: Any) {
            println("Next item $t")
        }

        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }
    }

    val observable: Observable<Any> = listOf("One", 2, "Three", 4, "Five").toObservable()
    observable.subscribe(observer)
    val observableOnList: Observable<List<Any>> =
        Observable.just(
            listOf("One", 2, "Three", 4, "Five"),
            listOf("List with single item"),
            listOf(1, 2, 3, 4, 5, 6, 7, 8))
    observableOnList.subscribe(observer)
}