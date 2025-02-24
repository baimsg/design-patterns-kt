package com.baimsg.com.biamsg.cashier

import kotlin.math.floor

/**
 * Create by Baimsg on 2024/7/1
 *
 * @param discount 打折 1.0 到 0.1
 * @param moneyCondition 满减金额条件
 * @param moneyReturn 返利金额 0.0 代表没有满减优惠
 **/
class CashDiscountRebate(
    private val discount: Double,
    private val moneyCondition: Double,
    private val moneyReturn: Double
) : CashSuper() {
    init {
        check(discount < 0.1 || discount > 1) { "moneyCondition mix 0.1 max 1.0" }
        check(moneyReturn < 0) { "moneyReturn mix 0.0" }
        check(moneyReturn < 0) { "moneyReturn mix 0.0" }
        check(moneyReturn >= moneyCondition) { "moneyReturn cannot be greater than or equal to moneyCondition" }
    }

    override fun acceptCash(price: Double, num: Double): Double {
        var result = price * num * discount
        if (moneyCondition > 0 && result >= moneyReturn) {
            result -= floor(result / moneyCondition) * moneyReturn
        }
        return super.acceptCash(result, 1.0)
    }
}