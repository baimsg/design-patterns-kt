package com.baimsg.com.baimsg.calcuator

/**
 * Create by Baimsg on 2024/6/22
 *
 * 取余数运算
 *
 **/
class Remainder : Operation() {
    override fun getResult(x: Double, y: Double): Double {
        return x.rem(y)
    }

    override fun getResult(x: Float, y: Float): Float {
        return x.rem(y)
    }
}