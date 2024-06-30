package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
object CashFactory {
    const val CASH_NORMAL = 0
    const val CASH_REBATE = 1
    const val CASH_RETURN = 2

    fun createCash(type: Int) = when (type) {
        CASH_NORMAL -> CashNormal()
        CASH_REBATE -> CashRebate(0.5)
        CASH_RETURN -> CashReturn(300.0, 50.0)
        else -> error("没有找到type[$type]")
    }
}