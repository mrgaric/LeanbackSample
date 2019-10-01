package i.d.leanback_sample.cards.menu

import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import i.d.leanback_sample.R
import i.d.leanback_sample.extensions.getColorRes

class MenuCardPresenter : Presenter() {

	override fun onCreateViewHolder(viewGroup: ViewGroup): Presenter.ViewHolder =
		ViewHolder(createView(viewGroup))

	private fun createView(viewGroup: ViewGroup) =
		viewGroup
			.context
			.let { context ->
				MenuCardView(context)
					.apply {
						setBackgroundColor(context.getColorRes(R.color.menu_item_background))
					}
			}

	override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, item: Any) =
		(viewHolder as ViewHolder)
			.bind(item as MenuCardItem)

	override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder) =
		(viewHolder as ViewHolder)
			.unbind()

	private inner class ViewHolder(view: MenuCardView) : Presenter.ViewHolder(view) {

		fun bind(item: MenuCardItem) = with(view as MenuCardView) {
			item.run {
				titleText = title
				descriptionText = description
				iconId = icon
			}
		}

		fun unbind() = with(view as MenuCardView) {
			titleText = ""
			descriptionText = ""
			iconId = 0
		}
	}
}