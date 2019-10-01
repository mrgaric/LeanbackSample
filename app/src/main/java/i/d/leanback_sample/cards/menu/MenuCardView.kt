package i.d.leanback_sample.cards.menu

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.DrawableRes
import androidx.leanback.widget.BaseCardView
import i.d.leanback_sample.R
import kotlinx.android.synthetic.main.view_menu_card.view.*

class MenuCardView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : BaseCardView(ContextThemeWrapper(context, R.style.MenuCardViewStyle), attrs, defStyleAttr) {

	var titleText: String = ""
		set(value) {
			field = value
			vTitle.text = value
		}

	var descriptionText: String = ""
		set(value) {
			field = value
			vDescription.text = value
		}

	@DrawableRes
	var iconId: Int = 0
		set(value) {
			field = value
			vIcon.setImageResource(value)
		}

	init {
		View.inflate(context, R.layout.view_menu_card, this)
		isFocusable = true
		isFocusableInTouchMode = true
	}
}