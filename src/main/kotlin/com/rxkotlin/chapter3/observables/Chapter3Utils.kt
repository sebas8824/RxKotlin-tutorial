package com.rxkotlin.chapter3.observables

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class Chapter3Utils {
    companion object Factory {
        fun createObserver(): Observer<Any> {
            val observer: Observer<Any> = object: Observer<Any> {
                override fun onComplete() {
                    println("All completed")
                }

                override fun onError(e: Throwable) {
                    println("Error occured ${e.message}")
                }

                override fun onNext(t: Any) {
                    println("Next item $t")
                }

                override fun onSubscribe(d: Disposable) {
                    println("New subscription")
                }
            }
            return observer
        }
    }
}
