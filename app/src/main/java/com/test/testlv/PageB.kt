package com.test.testlv

class PageB(val pagea: PageA) {

    fun click() {
        pagea.adapter.add("new item")
    }

}