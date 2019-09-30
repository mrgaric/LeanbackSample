package i.d.leanback_sample.cards.menu

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import i.d.leanback_sample.R
import kotlinx.android.synthetic.main.view_menu.view.*

class MenuView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

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
		orientation = VERTICAL
		gravity = Gravity.CENTER
		isFocusable = true
		isFocusableInTouchMode = true
	}

}