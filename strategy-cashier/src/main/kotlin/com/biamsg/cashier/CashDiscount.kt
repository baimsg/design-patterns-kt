package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 * @param discount 打折 1.0 到 0.1
 *
 **/
class CashDiscount(private val discount: Double) : CashSuper() {
    override fun acceptCash(price: Double, num: Double): Double {
        val result = price * num * discount
        return super.acceptCash(result, 1.0)
    }
}