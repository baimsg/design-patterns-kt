package com.baimsg.com.baimsg.calcuator.type

/**
 * Create by Baimsg on 2024/6/27
 *
 **/
enum class Operand(private val symbol: Char) {
    Zero('0'),
    One('1'),
    Tow('2'),
    Three('3'),
    Four('4'),
    Five('5'),
    Six('6'),
    Seven('7'),
    Eight('8'),
    Nine('9'),
    Point('.');

    companion object {
        operator fun get(c: Char): Operand? = entries.firstOrNull { it.symbol == c }
    }

}