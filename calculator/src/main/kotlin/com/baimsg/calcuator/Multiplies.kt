package com.baimsg.com.baimsg.calcuator

/**
 * Create by Baimsg on 2024/6/22
 *
 * 乘法运算
 *
 **/
class Multiplies : Operation() {
    override fun getResult(x: Double, y: Double): Double {
        return x.times(y)
    }

    override fun getResult(x: Float, y: Float): Float {
        return x.times(y)
    }
}