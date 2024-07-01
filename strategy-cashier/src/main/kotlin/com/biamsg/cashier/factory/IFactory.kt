package com.baimsg.com.biamsg.cashier.factory

import com.baimsg.com.biamsg.cashier.CashSuper

/**
 * Create by Baimsg on 2024/7/1
 *
 **/
interface IFactory {
    fun createCash(): CashSuper
}