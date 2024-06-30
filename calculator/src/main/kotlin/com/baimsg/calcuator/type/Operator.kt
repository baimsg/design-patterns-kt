package com.baimsg.com.baimsg.calcuator.type

/**
 * Create by Baimsg on 2024/6/27
 *
 **/
enum class Operator( val symbol: Char, val priority: Int) {
    Add('+', 1),
    Subtracts('-', 1),
    Remainder('%', 1),
    Multiplies('*', 2),
    Divides('/', 2),
    BRACKETS_LEFT('(', 3),
    BRACKETS_RIGHT(')', 3),
    Power('^', 4);

    companion object{
        operator fun get(c: Char): Operator? = entries.firstOrNull { it.symbol == c }
    }

}

