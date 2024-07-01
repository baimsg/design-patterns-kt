package com.baimsg.com.baimsg.pursue

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
class Suitors(
    name: String,
     var girl: Girl? = null
) : ISendGift {

    override fun giveDolls() {
        println("送${girl?.name}杨洋娃")
    }

    override fun giveFlowers() {
        println("送${girl?.name}鲜花")

    }

    override fun giveChocolate() {
        println("送${girl?.name}巧克力")
    }

}