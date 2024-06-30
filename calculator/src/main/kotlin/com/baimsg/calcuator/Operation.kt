package com.baimsg.com.baimsg.calcuator

/**
 * Create by Baimsg on 2024/6/22
 *
 **/
abstract class Operation {
    abstract fun getResult(x: Double, y: Double): Double
    abstract fun getResult(x: Float, y: Float): Float
}