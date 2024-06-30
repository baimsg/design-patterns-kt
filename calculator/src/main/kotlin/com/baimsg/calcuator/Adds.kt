package com.baimsg.com.baimsg.calcuator

/**
 * Create by Baimsg on 2024/6/22
 *
 * 加法运算
 *
 **/
class Adds : Operation() {
    override fun getResult(x: Double, y: Double): Double {
        return x.plus(y)
    }

    override fun getResult(x: Float, y: Float): Float {
        return x.plus(y)
    }
}