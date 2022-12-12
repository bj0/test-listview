package com.test.testlv

import androidx.activity.ComponentActivity

class PageA(val context: ComponentActivity) {

    val adapter = LvAdapter(context)

    init {
        // initial values
        adapter.add("item a")
        adapter.add("item b")
    }


    fun clicked(pos: Int) {

    }
}