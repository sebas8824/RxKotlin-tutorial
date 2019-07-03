package com.rxkotlin.chapter3.observables.create

import com.rxkotlin.chapter3.observables.Chapter3Utils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

/* Observable.create<T>
 * This method is useful when working with a custom data structure and want to have control
 * over what values are emitted. You can also emit values to Observer from a different thread
 */

fun main(args: Array<String>) {
    val observer = Chapter3Utils.createObserver()
    val observable: Observable<String> = Observable.create<String> {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)

    val anotherObservable: Observable<String> = Observable.create<String> { obs ->
        obs.onNext("Emit 1")
        obs.onNext("Emit 2")
        obs.onNext("Emit 3")
        obs.onNext("Emit 4")
        obs.onError(Exception("Sorry, shit happens!"))
    }

    anotherObservable.subscribe(observer)
}