package com.baimsg.com.baimsg.calcuator.factory

import com.baimsg.com.baimsg.calcuator.*
import com.baimsg.com.baimsg.calcuator.type.Operator

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
object FactoryBasic : IFactory {
    override fun createFactory(operator: Operator): Operation = when (operator) {
        Operator.Add -> Adds()
        Operator.Subtracts -> Subtracts()
        Operator.Multiplies -> Multiplies()
        Operator.Divides -> Divides()
        else -> error("FactoryBasic Operation not supported $operator")
    }
}