package com.rxkotlin.chapter3.observables.from

import com.rxkotlin.chapter3.observables.Chapter3Utils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/* Observable.from_post fix_
 * Lets you create an Observable instance from nearly every Kotlin structure.
 */

fun main(args: Array<String>) {
    val observer = Chapter3Utils.createObserver()

    /* Observable from a list of Strings
    * Check how Observable<T> is a String while the from method postfix is fromIterable accepting the list of Strings
    * */
    var list = listOf("String 1", "String 2", "String 3", "String 4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    val callable = object: Callable<String> {
        override fun call(): String {
            return "From Callable"
        }
    }

    /* Observable from a Callable of String
    * Check how Observable<T> is a String while the from method postfix is fromCallable accepting Callable<String>
    * */
    val observableFromCallable: Observable<String> = Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)


    /* Observable from a Future of String
    * Check how Observable<T> is a String while the from method postfix is fromFuture accepting Future<String>
    * */
    val future: Future<String> = object: Future<String> {
        override fun get(): String = "Hello from Future"
        override fun get(timeout: Long, unit: TimeUnit): String = "Hello from Future"
        override fun isDone(): Boolean = true
        override fun isCancelled(): Boolean = false
        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false
    }

    val observableFromFuture: Observable<String> = Observable.fromFuture(future)
    observableFromFuture.subscribe(observer)
}