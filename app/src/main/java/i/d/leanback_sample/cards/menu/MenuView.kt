package i.d.leanback_sample.cards.menu

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import i.d.leanback_sample.R
import i.d.leanback_sample.extensions.getDrawableRes
import kotlinx.android.synthetic.main.view_menu.view.vIcon
import kotlinx.android.synthetic.main.view_menu.view.vTitle

class MenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var titleText: String = ""
        set(value) {
            field = value
            vTitle.text = value
        }

    @DrawableRes
    var iconId: Int = 0
        set(value) {
            field = value
            vIcon.setImageResource(value)
        }

    init {
        View.inflate(context, R.layout.view_menu, this)
        isFocusable = true
        isFocusableInTouchMode = true
        foreground = context.getDrawableRes(R.drawable.menu_card_ripple)
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val states = super.onCreateDrawableState(extraSpace)
        return states.filter { it != android.R.attr.state_focused }.toIntArray()
    }

}