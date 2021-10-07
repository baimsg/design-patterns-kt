package com.baimsg

import java.math.BigDecimal
import kotlin.math.*

class Operation(private val expr: String, private val bdType: Int) {

    constructor(expr: String) : this(expr, BigDecimal.ROUND_DOWN)

    fun execute() = Operate().parse()

    private inner class Operate {
        //当前位置
        var pos = -1

        //char 转 int 的值
        var ch: Int = 0

        fun parse(): Double {
            nextChar()
            val x = parseExpression()
            if (pos < expr.length) throw RuntimeException("Unexpected: " + ch.toChar())
            return x
        }

        //查找下一个char
        fun nextChar() {
            ch = if (++pos < expr.length) expr[pos].code else -1
        }

        fun eat(charToEat: Int): Boolean {
            //循环检测是不是空格
            while (ch == ' '.code) nextChar()
            if (ch == charToEat) {
                nextChar()
                return true
            }
            return false
        }

        fun parseExpression(): Double {
            var x = BigDecimal(parseAndSub())
            while (true) {
                x = if (eat('&'.code)) BigDecimal(
                    x.toBigInteger().and(BigDecimal(parseAndSub()).toBigInteger())
                ) else if (eat('|'.code)) BigDecimal(
                    x.toBigInteger().or(BigDecimal(parseAndSub()).toBigInteger())
                ) else return x.toDouble()
            }
        }

        fun parseAndSub(): Double {
            var x = parseTerm()
            while (true) {
                if (eat('+'.code)) x += parseTerm()
                else if (eat('-'.code)) x -= parseTerm()
                else return x
            }
        }

        fun parseTerm(): Double {
            var x = BigDecimal(parseFactor().toString())
            while (true) {
                x = if (eat('*'.code)) x.multiply(BigDecimal(parseFactor()))
                else if (eat('/'.code)) x.divide(BigDecimal(parseFactor().toString()), 16, bdType)
                else if (eat('%'.code)) x.divideAndRemainder(BigDecimal(parseFactor().toString()))[1]
                else return x.toDouble()
            }
        }

        fun parseFactor(): Double {
            if (eat('+'.code)) return parseFactor()
            if (eat('-'.code)) return -parseFactor()
            var x = 0.0
            var y = 0.0
            var bool = true
            while (true) {
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    x = expr.substring(startPos, pos).toDouble()
                } else if (eat('Π'.code) || eat('π'.code)) {
                    x = Math.PI
                } else if (ch >= 'a'.code && ch <= 'z'.code || ch == '√'.code) {
                    while (ch >= 'a'.code && ch <= 'z'.code || ch == '√'.code) nextChar()
                    val func: String = expr.substring(startPos, pos)
                    x = parseFactor()
                    x = when (func) {
                        "sqrt", "√" -> sqrt(x)
                        "sin" -> sin(Math.toRadians(x))
                        "cos" -> cos(Math.toRadians(x))
                        "tan" -> tan(Math.toRadians(x))
                        else -> throw RuntimeException("Unknown function: $func")
                    }
                } else {
                    break
                }
                if (bool) {
                    y = x
                    bool = false
                } else {
                    x *= y
                    y = x
                }
            }
            if (eat('^'.code)) x = x.pow(parseFactor())
            return x
        }

    }
}