@file:Suppress("unused")

package gov.jeaco.testlv

import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.adapters.ListenerUtil
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

/**
 * interface for item click handler where we only care about the position
 */
fun interface ItemClickHandler {
    fun onItemClick(position: Int)
}

/**
 * a binding adapter for setOnItemClickListener for a ListView
 */

@BindingAdapter("onItemClick")
fun setOnItemClickListener(view: AdapterView<*>, newValue: ItemClickHandler) {
    view.onItemClickListener =
        OnItemClickListener { _, _, position, _ ->
            newValue.onItemClick(position)
        }
}

/**
 * a binding adapter for setting selected page in a ViewPager
 */

@BindingAdapter("selectedIndex")
fun setSelectedIndex(view: ViewPager2, index: Int) {
    if (view.currentItem != index) {
        view.setCurrentItem(index, true)
    }
}

/**
 * allows 2-way binding with selectedIndex on a ViewPager
 */
@InverseBindingAdapter(attribute = "selectedIndex", event = "selectedIndexAttrChanged")
fun getCurrentIndex(view: ViewPager2): Int = view.currentItem

/**
 * hook up event for determining when selectedIndex changes (for 2-way binding)
 */
@BindingAdapter("selectedIndexAttrChanged")
fun setListeners(view: ViewPager2, selectedIndexAttrChanged: InverseBindingListener?) {
    var newValue: OnPageChangeCallback? = null
    if (selectedIndexAttrChanged != null) {
        newValue = object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedIndexAttrChanged.onChange()
            }
        }
    }
    val oldValue = ListenerUtil.trackListener(view, newValue, R.id.selectedIndexListener)
    if (oldValue != null) {
        view.unregisterOnPageChangeCallback(oldValue)
    }
    if (newValue != null) {
        view.registerOnPageChangeCallback(newValue)
    }
}
