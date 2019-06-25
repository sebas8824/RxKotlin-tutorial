package com.rxkotlin.chapter2.inline

/*
* Inline functions:
* Are expressions defined in one line and not declared as a formal function
* Are an enhancement feature to improve the performance and memory opttimization of a program
* */

/* If we declare a function as inline, the code inside that function will replace all the function
*  calls, improving performance and keeping the freedom to change it intact */
inline fun doStuff(a: Int = 0) = a + (a * a)

fun main(args: Array<String>) {
    for (i in 1..10) {
        println("$i Outputs ${doStuff(i)}")
    }
}