package com.baimsg

import com.baimsg.com.biamsg.cashier.CashContext
import java.util.*

/**
 * Create by Baimsg on 2024/6/28
 *
 **/
fun main() {
    val scanner = Scanner(System.`in`)
    println("请选择模式")
    val s = scanner.nextInt()
    val ctx = CashContext(s)
    println(ctx.getResult(25.0, 10.0))

}