package com.baimsg

interface Compute<T> {
    var x: T
    var y: T
    fun count(): T
}