package com.baimsg.decorate

fun main() {
    //装饰模式
    val p = Person("小菜")
    val t = TShirts()
    val b = BigTrouser()
    val s = Sneakers()
    s.decorate(p)
    t.decorate(s)
    b.decorate(t)
    b.show()
}
