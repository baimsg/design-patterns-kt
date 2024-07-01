package com.baimsg.com.baimsg.calcuator.factory

import com.baimsg.com.baimsg.calcuator.Operation
import com.baimsg.com.baimsg.calcuator.Power
import com.baimsg.com.baimsg.calcuator.Remainder
import com.baimsg.com.baimsg.calcuator.type.Operator

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
object FactoryAdvanced : IFactory {
    override fun createFactory(operator: Operator): Operation =
        when (operator) {
            Operator.Remainder -> Remainder()
            Operator.Power -> Power()
            else -> error("FactoryAdvanced Operation not supported $operator")
        }
}