package com.baimsg.com.biamsg.cashier

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
open class CashSuper : ISale {
    private var component: ISale? = null

    fun decorate(component: ISale) {
        this.component = component
    }

    override fun acceptCash(price: Double, num: Double): Double {
        return component?.acceptCash(price, num) ?: 0.0
    }
}