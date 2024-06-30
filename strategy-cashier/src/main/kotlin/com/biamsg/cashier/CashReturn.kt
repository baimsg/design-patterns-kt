package com.baimsg.com.biamsg.cashier

import kotlin.math.floor

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
class CashReturn(private val moneyCondition: Double, private val moneyReturn: Double) : CashSuper() {
    override fun acceptCash(price: Double, num: Double): Double {
        var result = price * num
        if (moneyCondition > 0 && result >= moneyReturn) {
            result -= floor(result / moneyCondition) * moneyReturn
        }
        return result
    }
}