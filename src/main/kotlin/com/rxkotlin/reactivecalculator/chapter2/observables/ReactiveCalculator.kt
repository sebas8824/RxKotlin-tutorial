package com.rxkotlin.reactivecalculator.chapter2.observables

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.regex.Matcher
import java.util.regex.Pattern

class ReactiveCalculator(a: Int, b: Int) {
    val subjectCalc: Subject<ReactiveCalculator> = PublishSubject.create()
    var nums:Pair<Int,Int> = Pair(0,0)

    init{
        nums = Pair(a,b)
        subjectCalc.subscribe({
            with(it) {
                calculateAddition()
                calculateSubstraction()
                calculateMultiplication()
                calculateDivision()
            }
        })
        subjectCalc.onNext(this)
    }

    inline fun calculateAddition(): Int {
        val result = nums.first + nums.second
        println("Add = $result")
        return result
    }

    inline fun calculateSubstraction(): Int {
        val result = nums.first - nums.second
        println("Substract = $result")
        return result
    }

    inline fun calculateMultiplication(): Int {
        val result = nums.first * nums.second
        println("Multyply = $result")
        return result
    }

    inline fun calculateDivision(): Double {
        val result = (nums.first * 1.0) / (nums.second * 1.0)
        println("Multiply = $result")
        return result
    }

    fun modifyNumbers (a: Int = nums.first, b: Int = nums.second) {
        nums = Pair(a, b)
        subjectCalc.onNext(this)
    }

    fun handleInput(inputLine:String?) {
        if (!inputLine.equals("exit")) {
            val pattern: Pattern = Pattern.compile("([a|b])(?:\\s)?=(?:\\s)?(\\d*)");
            var a: Int? = null
            var b: Int? = null
            val matcher: Matcher = pattern.matcher(inputLine)
            if (matcher.matches() && matcher.group(1) != null && matcher.group(2) != null) {
                if (matcher.group(1).toLowerCase().equals("a")) {
                    a = matcher.group(2).toInt()
                } else if (matcher.group(1).toLowerCase().equals("b")) {
                    b = matcher.group(2).toInt()
                }
            }
            when {
                a != null && b != null -> modifyNumbers(a, b)
                a != null -> modifyNumbers(a = a)
                b != null -> modifyNumbers(b = b)
                else -> println("Invalid Input")
            }
        }
    }
}