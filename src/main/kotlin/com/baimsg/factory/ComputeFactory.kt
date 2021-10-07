package com.baimsg.factory

object ComputeFactory {

    fun createCompute(key: String): Compute<Double>? {
        return when (key) {
            "+" -> ComputeAdd()
            "-" -> ComputeSub()
            "*" -> ComputeMultiply()
            "/" -> ComputeDivision()
            else -> null
        }
    }
}