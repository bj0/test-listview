package com.test.testlv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.activity.ComponentActivity
import com.test.testlv.databinding.ItemBinding
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Adapter for the listview
 */
class LvAdapter(val context: ComponentActivity) : BaseAdapter() {

    val list = mutableListOf<String>()

    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): Any = list[p0]

    override fun getItemId(p0: Int): Long = list[p0].hashCode().toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        logger.warn { "lv get view $p0" }
        val binding = ItemBinding.inflate(LayoutInflater.from(context), p2, false)
        binding.lifecycleOwner = context
        binding.vm = list[p0]
        return binding.root
    }

    fun add(item: String) {
        list.add(item)
        notifyDataSetChanged()
    }
}