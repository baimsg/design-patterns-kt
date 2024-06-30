package com.baimsg.com.baimsg.dress

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
open class Finery : ICharacter {

    private var component: ICharacter? = null

    fun decorate(component: ICharacter) {
        this.component = component
    }

    override fun show() {
        component?.show()
    }
}