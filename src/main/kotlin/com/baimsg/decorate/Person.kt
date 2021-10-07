package com.baimsg.decorate

open class Person(private val name: String) {
    constructor() : this("")

    open fun show() {
        print("装扮的是$name")
    }
}