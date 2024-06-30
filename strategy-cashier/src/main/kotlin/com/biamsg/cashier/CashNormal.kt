package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
class CashNormal : CashSuper() {

    override fun acceptCash(price: Double, num: Double): Double {
        return price * num
    }

}