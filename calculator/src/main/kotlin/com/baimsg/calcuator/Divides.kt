package com.baimsg.com.baimsg.calcuator

/**
 * Create by Baimsg on 2024/6/22
 *
 * 除法运算
 *
 **/
class Divides : Operation() {
    override fun getResult(x: Double, y: Double): Double {
        if (y == 0.0) return 0.0
        return x.div(y)
    }

    override fun getResult(x: Float, y: Float): Float {
        if (y == 0f) return 0f
        return x.div(y)
    }
}