package com.test.testlv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.test.testlv.databinding.ItemBinding
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class ItemHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

/**
 * Adapter for the listview
 */
class LvAdapter(val context: ComponentActivity) : RecyclerView.Adapter<ItemHolder>() {

    val list = mutableListOf<String>()

    fun add(item: String) {
        list.add(item)
        notifyItemInserted(list.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ItemBinding.inflate(LayoutInflater.from(context), parent, false).also {
            it.lifecycleOwner = context
        })
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.binding.vm = list[position]
    }

    override fun getItemCount(): Int = list.size
}