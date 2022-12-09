package gov.jeaco.testlv

import kotlinx.coroutines.flow.MutableStateFlow
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass

class AppVm {

    var itemBinding: OnItemBindClass<Any> = OnItemBindClass()

    val pages: List<Any>

    val titles: List<String>

    var selectedPosition = MutableStateFlow(0)


    init {

        itemBinding.map(PageA::class.java, BR.vm, R.layout.pagea)
        itemBinding.map(PageB::class.java, BR.vm, R.layout.pageb)

        val pagea = PageA()
        pages = listOf(pagea, PageB(pagea))
        titles = listOf("Page A", "Page B")

    }
}