package com.baimsg.decorate

open class Finery : Person() {

    private var person: Person? = null

    fun decorate(person: Person) {
        this.person = person
    }

    override fun show() {
        person?.show()
    }

}