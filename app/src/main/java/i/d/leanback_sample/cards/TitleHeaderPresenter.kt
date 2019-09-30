package i.d.leanback_sample.cards

import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderPresenter
import androidx.leanback.widget.RowHeaderView
import i.d.leanback_sample.R

class TitleHeaderPresenter(
	private val textSize: Float,
	private val bottom: Int
) : RowHeaderPresenter() {

	override fun onCreateViewHolder(parent: ViewGroup?): Presenter.ViewHolder =
		super.onCreateViewHolder(parent)
			.apply {
				val rowHeaderView = view.findViewById(R.id.row_header) as RowHeaderView
				rowHeaderView.textSize = textSize
				rowHeaderView.setPadding(0, 0, 0, bottom)
			}

}