package com.baimsg.strategy

/**
 * 现金收费抽象类
 */
abstract class CashSuper {
    abstract fun acceptCash(money: Double): Double
}