package com.baimsg.com.baimsg.calcuator

import kotlin.math.pow

/**
 * Create by Baimsg on 2024/6/22
 *
 * 幂运算
 *
 **/
class Power : Operation() {
    override fun getResult(x: Double, y: Double): Double {
        return x.pow(y)
    }

    override fun getResult(x: Float, y: Float): Float {
        return x.pow(y)
    }
}