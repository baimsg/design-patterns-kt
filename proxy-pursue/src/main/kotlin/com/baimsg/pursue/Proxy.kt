package com.baimsg.com.baimsg.pursue

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
class Proxy(private val suitors: Suitors) : ISendGift {

    override fun giveDolls() {
        suitors.giveDolls()
    }

    override fun giveFlowers() {
        suitors.giveFlowers()

    }

    override fun giveChocolate() {
        suitors.giveChocolate()
    }
}