package gov.jeaco.testlv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import gov.jeaco.testlv.databinding.MainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = DataBindingUtil.setContentView<MainBinding>(this, R.layout.main)
        binding.vm = AppVm()
    }
}

