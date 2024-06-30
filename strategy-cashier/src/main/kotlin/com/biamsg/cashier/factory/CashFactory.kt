package com.baimsg.com.biamsg.cashier.factory

import com.baimsg.com.biamsg.cashier.CashNormal
import com.baimsg.com.biamsg.cashier.CashRebate
import com.baimsg.com.biamsg.cashier.CashReturn

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
object CashFactory {

    fun createCash(type: Int) = when (type) {
        0 -> CashNormal()
        1 -> CashRebate(0.5)
        2 -> CashReturn(100.0, 10.0)
        3 -> {
            //使用装饰模式
            val normal = CashNormal()
            val rebate = CashRebate(0.5)
            val cashReturn = CashReturn(20.0, 2.0)
            rebate.decorate(normal)
            cashReturn.decorate(rebate)
            cashReturn
        }

        else -> error("没有找到type[$type]")
    }
}