package i.d.leanback_sample.brows

import androidx.leanback.widget.HeaderItem

class IconHeaderItem(
    name: String,
    id: Long = -1,
    val iconResId: Int = NO_ICON
) : HeaderItem(id, name) {

    companion object {
        val NO_ICON = -1
    }
}
