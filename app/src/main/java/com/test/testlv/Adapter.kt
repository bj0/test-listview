package com.test.testlv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.test.testlv.databinding.PageaBinding
import com.test.testlv.databinding.PagebBinding

/**
 * Adapter for the viewpager
 */
class Adapter(val pages: List<Any>, val context: ComponentActivity) :
    RecyclerView.Adapter<Holder>() {

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            when (viewType) {
                0 -> PageaBinding.inflate(LayoutInflater.from(context), parent, false).also {
                    it.lifecycleOwner = context
                    it.list.adapter = (pages[0] as PageA).adapter
                }
                else -> PagebBinding.inflate(LayoutInflater.from(context), parent, false).also {
                    it.lifecycleOwner = context
                }
            }
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        when (position) {
            0 -> (holder.binding as PageaBinding).vm = pages[0] as PageA
            1 -> (holder.binding as PagebBinding).vm = pages[1] as PageB
        }
    }

    override fun getItemCount(): Int = pages.size

}

class Holder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)