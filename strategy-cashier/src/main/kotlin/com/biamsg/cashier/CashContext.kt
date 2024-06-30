package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
class CashContext(type: Int) {

    private val cashSuper: CashSuper = CashFactory.createCash(type)

    fun getResult(price: Double, num: Double): Double {
        return cashSuper.acceptCash(price, num)
    }
}