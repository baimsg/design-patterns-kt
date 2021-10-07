package com.baimsg.strategy

class CashContext(type: String) {
    private var cs: CashSuper

    init {
        cs = when (type) {
            "满400返100" -> CashReturn(400.0, 100.0)
            "打8折" -> CashRebate(0.8)
            else -> CashNormal()
        }
    }

    fun getResult(money: Double): Double {
        return cs.acceptCash(money)
    }
}