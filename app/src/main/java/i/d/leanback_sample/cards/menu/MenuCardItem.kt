package i.d.leanback_sample.cards.menu

import androidx.annotation.DrawableRes

data class MenuCardItem(
	val title: String,
	val description: String,
	@DrawableRes
	val icon: Int
)