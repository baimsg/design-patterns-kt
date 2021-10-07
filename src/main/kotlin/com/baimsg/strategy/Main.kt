package com.baimsg.strategy

import java.lang.Exception
import java.util.*

/**
 * 策略模式
 */

private val types = arrayOf("满400返100", "打8折", "正常收费")

//商店商品
private val materials = mapOf(
    "耳机" to 200,
    "鼠标" to 140,
    "手机" to 1800,
    "手机壳" to 60,
    "薯片" to 10
)

//购物车
private val shopping = mutableMapOf<String, Int>()
fun main() {


    println("商品列表如下：\n商品\t\t单价")
    for ((key, value) in materials) {
        println("$key --> ￥$value")
    }
    println("输入商品名称 数量即可选择\n例如：薯片 10")
    val scanner = Scanner(System.`in`)
    while (true) {
        val inStr = scanner.nextLine()
        if (inStr == "结算") {
            println("正在结算ing...")
            break
        }
        if (inStr == "购物车") {
            println("您的购物车如下：")
            for ((name, num) in shopping) {
                println("$name * $num")
            }
            outTip()
            continue
        }
        val items = inStr.split("[xX\\* ]".toRegex())
        if (materials.containsKey(items[0])) {
            if (items.size == 1) {
                addShopping(items[0], 1)
                println("${items[0]}*1已加入购物车！")
                outTip()
            } else {
                try {
                    addShopping(items[0], items[1].toInt())
                    println("${items[0]}*${items[1]}已加入购物车！")
                    outTip()
                } catch (e: Exception) {
                    e(e.message)
                }
            }
        } else {
            e(inStr)
        }
    }
    val type = types.random()
    val cashContext = CashContext(type)
    println("您的购物车如下：")
    var total = 0
    for ((name, num) in shopping) {
        println("$name * $num")
        total += materials[name]?.times(num) ?: 0
    }
    println("总计：￥$total")
    println("折扣：$type")
    println("收费：${cashContext.getResult(total.toDouble())}")
}

private fun outTip() {
    Thread.sleep(200)
    System.err.println("发送：购物车 可以查看\n发送：结算 可以结算")
}

private fun e(msg: String?) {
    System.err.println("输入指令异常：$msg")

}

private fun addShopping(name: String, num: Int) {
    shopping.apply {
        if (containsKey(name)) {
            put(name, (get(name) ?: 0) + num)
        } else {
            put(name, num)
        }
    }
}