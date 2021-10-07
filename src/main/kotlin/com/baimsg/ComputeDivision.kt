package com.baimsg

class ComputeDivision(
    override var x: Double = 0.0,
    override var y: Double = 0.0
) : Compute<Double> {
    override fun count(): Double {
        return x / y
    }
}