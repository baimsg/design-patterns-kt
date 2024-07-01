package com.baimsg.com.baimsg.calcuator.factory

import com.baimsg.com.baimsg.calcuator.Operation
import com.baimsg.com.baimsg.calcuator.type.Operator

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
interface IFactory {
    fun createFactory(operator: Operator): Operation
}