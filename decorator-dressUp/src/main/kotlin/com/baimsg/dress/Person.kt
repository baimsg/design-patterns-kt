package com.baimsg.com.baimsg.dress

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
class Person(private val name: String) : ICharacter {
    override fun show() {
        println("装扮的是$name")
    }
}