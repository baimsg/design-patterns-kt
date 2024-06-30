package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
interface ISale {
    fun acceptCash(price: Double, num: Double): Double
}