package i.d.leanback_sample.cards.menu

import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import i.d.leanback_sample.R
import i.d.leanback_sample.extensions.getColorRes
import i.d.leanback_sample.extensions.getDimensionPixelSizeRes

class MenuPresenter : Presenter() {

	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		viewGroup
			.context
			.let { context ->
				MenuView(context)
					.apply {
						layoutParams = ViewGroup.LayoutParams(
							context.getDimensionPixelSizeRes(R.dimen.menu_item_width),
							context.getDimensionPixelSizeRes(R.dimen.menu_item_height)
						)
						setBackgroundColor(context.getColorRes(R.color.menu_item_background))
					}
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as MenuItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: MenuView) : Presenter.ViewHolder(view) {

		fun bind(item: MenuItem) = with(view as MenuView) {
			item.run {
				titleText = title
				iconId = icon
			}
		}

		fun unbind() = with(view as MenuView) {
			titleText = ""
			iconId = 0
		}
	}
}