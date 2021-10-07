package com.baimsg.decorate

class Suit : Finery() {
    override fun show() {
        println("西装")
        super.show()
    }
}