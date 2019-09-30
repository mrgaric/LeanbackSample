package i.d.leanback_sample.cards.menu

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import i.d.leanback_sample.R
import i.d.leanback_sample.extensions.getDimensionPixelSizeRes

class MenuPresenter : Presenter() {

	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		viewGroup
			.context
			.let { context ->
				ImageCardView(context)
					.apply {
						isFocusable = true
						isFocusableInTouchMode = true
						setMainImageDimensions(
							context.getDimensionPixelSizeRes(R.dimen.menu_item_width),
							context.getDimensionPixelSizeRes(R.dimen.menu_item_height)
						)
					}
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as MenuItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: ImageCardView) : Presenter.ViewHolder(view) {

		fun bind(item: MenuItem) = with(view as ImageCardView) {
			item.run {
				mainImage = view.context.getDrawable(icon)
				titleText = title
			}
		}

		fun unbind() = with(view as ImageCardView) {
			mainImage = null
			badgeImage = null
			titleText = ""
			contentDescription = ""
		}
	}
}