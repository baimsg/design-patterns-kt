package com.baimsg.strategy

import kotlin.math.floor

/**
 * 返现收费类
 * @param moneyCondition 目标金额
 * @param moneyReturn 返现金额
 */
class CashReturn(
    private val moneyCondition: Double,
    private val moneyReturn: Double
) : CashSuper() {

    override fun acceptCash(money: Double): Double {
        var result = money
        if (money >= moneyCondition) {
            //大于返利条件，则减去返利值
            result = money - floor(money / moneyCondition) * moneyReturn
        }
        return result
    }
}