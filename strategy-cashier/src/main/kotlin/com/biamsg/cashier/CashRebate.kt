package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
class CashRebate(private val moneyRebate: Double) : CashSuper() {
    override fun acceptCash(price: Double, num: Double): Double {
        val result = price * num * moneyRebate
        return super.acceptCash(result, 1.0)
    }
}