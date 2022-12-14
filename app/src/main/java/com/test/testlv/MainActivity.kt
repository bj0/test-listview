package com.test.testlv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.test.testlv.databinding.MainBinding
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<MainBinding>(this, R.layout.main)
        binding.lifecycleOwner = this
        binding.vm = AppVm()

        val pagea = PageA(this)
        val pages = listOf(pagea, PageB(pagea))

        val adapter = Adapter(pages, this)
        binding.tabPager.adapter = adapter

        binding.executePendingBindings()
        val root = binding.root;
    }
}

