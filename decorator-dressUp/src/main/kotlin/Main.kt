package com.baimsg

import com.baimsg.com.baimsg.dress.Person
import com.baimsg.com.baimsg.dress.Shorts
import com.baimsg.com.baimsg.dress.Sweater

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
fun main() {
    val person = Person("baimsg")
    val short = Shorts()
    short.decorate(person)
    val sweater = Sweater()
    sweater.decorate(short)
    sweater.show()

}