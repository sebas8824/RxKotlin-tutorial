package com.rxkotlin.chapter2.inline

import com.rxkotlin.chapter2.isEven


/*
* The compiler replaces the definition of inline functions at compile time instead of referring to the function
* definition at runtime.
* */
inline fun highOrderFunctionInline(a: Int, validityCheckFunction: (a: Int) -> Boolean) {
    if(validityCheckFunction(a)) {
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}

fun main(args: Array<String>) {
    highOrderFunctionInline(12, {a: Int -> a.isEven()})
    highOrderFunctionInline(19, {a: Int -> a.isEven()})
}