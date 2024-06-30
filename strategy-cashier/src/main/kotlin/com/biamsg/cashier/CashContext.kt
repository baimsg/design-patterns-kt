package com.baimsg.com.biamsg.cashier

import com.baimsg.com.biamsg.cashier.factory.CashFactory

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
class CashContext(type: Int) {

    private val component: ISale = CashFactory.createCash(type)

    fun getResult(price: Double, num: Double): Double {
        return component.acceptCash(price, num)
    }
}