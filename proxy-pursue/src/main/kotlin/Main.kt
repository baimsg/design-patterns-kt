package com.baimsg

import com.baimsg.com.baimsg.pursue.Girl
import com.baimsg.com.baimsg.pursue.Proxy
import com.baimsg.com.baimsg.pursue.Suitors

/**
 * Create by Baimsg on 2024/6/30
 *
 **/
fun main() {
    val suitors = Suitors("libobo")
    val fengjie = Girl("fengjie")
    suitors.girl = fengjie

    Proxy(suitors).giveDolls()

}