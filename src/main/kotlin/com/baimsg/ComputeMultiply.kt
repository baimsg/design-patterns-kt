package com.baimsg

class ComputeMultiply(
    override var x: Double = 0.0,
    override var y: Double = 0.0
) : Compute<Double> {
    override fun count(): Double {
        return x * y
    }
}