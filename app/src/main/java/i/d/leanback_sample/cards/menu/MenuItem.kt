package i.d.leanback_sample.cards.menu

import androidx.annotation.DrawableRes

data class MenuItem(
	val title: String,
	@DrawableRes
	val icon: Int
)