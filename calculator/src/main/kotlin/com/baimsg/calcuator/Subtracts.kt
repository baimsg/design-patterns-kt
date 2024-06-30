package com.baimsg.com.baimsg.calcuator

/**
 * Create by Baimsg on 2024/6/22
 *
 * 减法运算
 *
 **/
class Subtracts : Operation() {
    override fun getResult(x: Double, y: Double): Double {
        return x.minus(y)
    }

    override fun getResult(x: Float, y: Float): Float {
        return x.minus(y)
    }

}