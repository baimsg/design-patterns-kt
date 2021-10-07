package com.baimsg.strategy

/**
 * 正常收费子类
 */
class CashNormal : CashSuper() {
    override fun acceptCash(money: Double): Double {
        return money
    }
}