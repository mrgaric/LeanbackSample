package i.d.leanback_sample.cards.leanback

import android.view.ContextThemeWrapper
import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import i.d.leanback_sample.R
import i.d.leanback_sample.extensions.getDimensionPixelSizeRes

class LeanbackCardPresenter : Presenter() {

	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		viewGroup
			.context
			.let { context ->
				ImageCardView(ContextThemeWrapper(context, R.style.ImageCardTheme))
					.apply {
						isFocusable = true
						isFocusableInTouchMode = true
						setMainImageDimensions(
							context.getDimensionPixelSizeRes(R.dimen.card_width),
							context.getDimensionPixelSizeRes(R.dimen.card_height)
						)
						cardType = BaseCardView.CARD_TYPE_INFO_OVER
					}
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as LeanbackCardItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: ImageCardView) : Presenter.ViewHolder(view) {

		private var requestManager: RequestManager? = null
		private val imageTarget = ImageCardViewTarget(view)

		fun bind(item: LeanbackCardItem) = with(view as ImageCardView) {
			item.run {
				requestManager = Glide.with(view)
				requestManager
					?.load(image)
					?.into(imageTarget)
				titleText = title
				contentText = content
				badgeImage = context.getDrawable(badgeIcon)
			}
		}

		fun unbind() = with(view as ImageCardView) {
			requestManager?.clear(imageTarget)
			mainImage = null
			badgeImage = null
			titleText = ""
			contentText = ""
		}
	}
}