package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
abstract class CashSuper {
    abstract fun acceptCash(price: Double, num: Double): Double
}