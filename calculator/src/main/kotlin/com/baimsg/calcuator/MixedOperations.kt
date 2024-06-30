package com.baimsg.com.baimsg.calcuator

import com.baimsg.com.baimsg.calcuator.type.Operand
import com.baimsg.com.baimsg.calcuator.type.Operator
import java.util.*


/**
 * Create by Baimsg on 2024/6/27
 *
 **/
object MixedOperations {

    fun calculate(formula: String, onFail: (Throwable) -> Unit = {}) {
        runCatching {
            resolveExpr(formula.replace(" ", ""))
        }.onFailure {
            onFail(it)
        }
    }

    /**
     * 将表达式转换成集合形式
     * @param exp 表达式
     */
    private fun resolveExpr(exp: String) {
        val list: LinkedList<String> = LinkedList<String>()
        val value = StringBuilder()
        exp.forEach { c ->
            val operator = Operator[c]
            val operand = Operand[c]
            if (operator != null) {
                if (value.isNotEmpty()) {
                    list.add(value.toString())
                    value.clear()
                }
                list.add(c.toString())
            } else if (operand != null) {
                value.append(c)
            } else {
                error("无法解析的符号[$c]")
            }
        }
        if (value.isNotEmpty()) {
            list.add(value.toString())
        }
        if (list.size % 2 == 0) error("无法解析表达式[$exp] ")
        println(list)
        dealExpr(list)
    }

    /**
     * 将集合表达式转换成中缀表达式
     * @param expList 表达式集合
     */
    private fun dealExpr(expList: List<String>) {
        val operands: LinkedList<String> = LinkedList()
        val operators = Stack<Char>()
        expList.forEach { s ->
            val c = s.first()
            val operator = Operator[c]
            val operand = Operand[c]
            if (operand != null) {
                //操作数直接入队列
                operands.add(s)
            } else if (operator != null) {
                when (operator) {
                    Operator.BRACKETS_LEFT -> {
                        //左括号入栈
                        operators.push(c)
                    }

                    Operator.BRACKETS_RIGHT -> {
                        //右括号: 循环将栈顶的运算符取出并存入队列，直到取出左括号
                        while (true) {
                            if (operators.empty()) {
                                error("缺少左括号!")
                            } else if (Operator.BRACKETS_LEFT.symbol == operators.peek()) {
                                operators.pop()
                                break
                            } else {
                                operands.add(operators.pop().toString())
                            }
                        }
                    }

                    else -> {
                        //非括号类运算符
                        if (!operators.empty()) {
                            val operatorTop = Operator[operators.peek()] ?: error("无法解析符号[${operators.peek()}]")
                            //当前运算符优先级大于栈顶运算符优先级，或者栈顶为左括号时，当前运算符直接入栈
                            if (operator.priority > operatorTop.priority
                                || Operator.BRACKETS_LEFT == operatorTop
                            ) {
                                operators.push(c)
                            }
                            //否则，将栈顶的运算符取出并存入队列，然后将自己入栈
                            else {
                                operands.add(operators.pop().toString())
                                operators.push(c)
                            }
                        } else {
                            operators.push(c)
                        }
                    }
                }
            }
        }
        while (!operators.empty()) {
            val str: Char = operators.peek()
            if (Operator.BRACKETS_LEFT.symbol == str) {
                error("缺少右括号! ")
            } else {
                operands.add(operators.pop().toString())
            }
        }
        println(operands)
        calculate(operands)
    }

    private fun calculate(expList: List<String>) {
        val stack = Stack<String>()
        expList.forEach { str ->
            val c = str.first()
            val operator = Operator[c]
            val operand = Operand[c]
            if (operand != null) {
                stack.push(str);
            } else if (operator != null) {
                //目前仅针对二元运算符
                var x: String? = ""
                var y: String? = ""
                if (!stack.empty()) {
                    y = stack.pop()
                }
                if (!stack.empty()) {
                    x = stack.pop()
                }
                if (!x.isNullOrEmpty() && !y.isNullOrEmpty()) {
                    val result: String = operation(x, y, operator) ?: error("运算异常")
                    stack.push(result)
                } else {
                    error("运算异常")
                }
            }
        }
        println(stack.pop())
    }

    private fun operation(x: String, y: String, operator: Operator): String {
        val operation = when (operator) {
            Operator.Add -> Adds()
            Operator.Subtracts -> Subtracts()
            Operator.Multiplies -> Multiplies()
            Operator.Divides -> Divides()
            Operator.Remainder -> Remainder()
            Operator.Power -> Power()
            else -> error("不支持的运算符")
        }
        return "${operation.getResult(x.toDouble(), y.toDouble())}"
    }

}