package com.baimsg.com.biamsg.cashier

import kotlin.math.floor

/**
 * Create by Baimsg on 2024/6/28
 *
 * @param moneyCondition 满减金额条件
 * @param moneyReturn 返利金额 0.0 代表没有满减优惠
 *
 **/
class CashRebate(
    private val moneyCondition: Double,
    private val moneyReturn: Double
) : CashSuper() {
    override fun acceptCash(price: Double, num: Double): Double {
        var result = price * num
        if (moneyCondition > 0 && result >= moneyReturn) {
            result -= floor(result / moneyCondition) * moneyReturn
        }
        return super.acceptCash(result, 1.0)
    }
}