package com.baimsg.strategy

/**
 * 打折收费子类
 * @param moneyRebate 打折折扣
 */
class CashRebate(private val moneyRebate: Double) : CashSuper() {
    override fun acceptCash(money: Double): Double {
        return moneyRebate * money
    }
}