package com.baimsg.factory

interface Compute<T> {
    var x: T
    var y: T
    fun count(): T
}