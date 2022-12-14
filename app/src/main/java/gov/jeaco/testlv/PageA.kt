package gov.jeaco.testlv

import kotlinx.coroutines.flow.MutableStateFlow
import me.tatarka.bindingcollectionadapter2.ItemBinding
import java.util.function.Consumer

private val logger = mu.KotlinLogging.logger {}

class PageA {

    val itemBinding = ItemBinding.of<String>(BR.vm, R.layout.item)
        .bindExtra(BR.clicked, Consumer { s: String -> clicked(s) })

    val items = MutableStateFlow(emptyList<String>())


    init {
        items.value = listOf("item a", "item b")
    }


    fun clicked(item: String) {
        logger.warn { "$item clicked!" }
    }
}