package com.baimsg

import com.baimsg.decorate.BigTrouser
import com.baimsg.decorate.Person
import com.baimsg.decorate.Sneakers
import com.baimsg.decorate.TShirts

fun main() {
    val p = Person("小菜")
    val t = TShirts()
    val b = BigTrouser()
    val s = Sneakers()
    s.decorate(p)
    t.decorate(s)
    b.decorate(t)
    b.show()
}
