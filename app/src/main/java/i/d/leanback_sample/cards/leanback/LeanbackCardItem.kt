package i.d.leanback_sample.cards.leanback

import androidx.annotation.DrawableRes

data class LeanbackCardItem(
	val title: String,
	val content: String,
	@DrawableRes
	val image: Int,
	@DrawableRes
	val badgeIcon: Int
)