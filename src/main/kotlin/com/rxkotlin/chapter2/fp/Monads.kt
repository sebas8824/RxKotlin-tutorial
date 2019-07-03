package com.rxkotlin.chapter2.fp

import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

/*
* Monad:
* A structure that creates a new type by encapsulating a value and adding
* some extra functionalities to it
* */

fun main(args: Array<String>) {

    /*
    * Maybe is a monad that encapsulates an Int with some added functionalities
    * Can have or not have a value hence onComplete, onError or onSuccess
    * */
    val maybeValue: Maybe<Int> = Maybe.just(14)

    maybeValue.subscribeBy(
        onComplete = { println("Completed Empty") },
        onError = { println("Error $it") },
        onSuccess = { println("Completed with value $it") }
    )

    val maybeEmpty: Maybe<Int> = Maybe.empty()
    maybeEmpty.subscribeBy(
        onComplete = { println("Completed Empty") },
        onError = { println("Error $it") },
        onSuccess = { println("Completed with value $it") }
    )
}