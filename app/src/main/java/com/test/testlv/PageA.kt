package com.test.testlv

import android.content.Context

class PageA(val context: Context) {

    val adapter = LvAdapter(context)

    init {
        // initial values
        adapter.add("item a")
        adapter.add("item b")
    }


    fun clicked(pos: Int) {

    }
}