package com.baimsg.com.biamsg.cashier.factory

import com.baimsg.com.biamsg.cashier.CashNormal
import com.baimsg.com.biamsg.cashier.CashDiscount
import com.baimsg.com.biamsg.cashier.CashRebate

/**
 * Create by Baimsg on 2024/6/28
 **/
object CashFactory {

    fun createCash(type: Int) = when (type) {
        0 -> CashNormal()
        1 -> CashDiscount(0.5)
        2 -> CashRebate(100.0, 10.0)
        3 -> {
            //使用装饰模式
            val normal = CashNormal()
            val rebate = CashDiscount(0.5)
            val cashRebate = CashRebate(20.0, 2.0)
            rebate.decorate(normal)
            cashRebate.decorate(rebate)
            cashRebate
        }

        else -> error("没有找到type[$type]")
    }
}