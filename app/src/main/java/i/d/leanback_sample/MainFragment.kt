package i.d.leanback_sample

import android.os.Bundle
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import i.d.leanback_sample.cards.TitleHeaderPresenter
import i.d.leanback_sample.cards.leanback.LeanbackCardItem
import i.d.leanback_sample.cards.leanback.LeanbackCardPresenter
import i.d.leanback_sample.extensions.getDimensionPixelSizeRes
import i.d.leanback_sample.extensions.getDimensionRes

class MainFragment : RowsSupportFragment() {

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		initViewWithLeanbackCard(savedInstanceState)
		setOnItemViewClickedListener { _, _, _, _ -> }
	}

	private fun initViewWithLeanbackCard(savedInstanceState: Bundle?) {
		val cardAdapter = ArrayObjectAdapter(LeanbackCardPresenter())
		cardAdapter.addAll(0, getLeanbackCardItems())
		setCardAdapter(cardAdapter)
	}

	private fun setCardAdapter(cardAdapter: ArrayObjectAdapter) {
		val header = HeaderItem("Finch")
		val rowPresenter = getRowPresenter()
		val rowsAdapter = ArrayObjectAdapter(rowPresenter)
		rowsAdapter.add(ListRow(header, cardAdapter))
		adapter = rowsAdapter
	}

	private fun getRowPresenter() =
		ListRowPresenter()
			.apply {
				context?.let { context ->
					headerPresenter = TitleHeaderPresenter(
						context.getDimensionRes(R.dimen.title_text_size),
						context.getDimensionPixelSizeRes(R.dimen.title_bottom_padding)
					)
				}
			}

	private fun getLeanbackCardItems(): List<LeanbackCardItem> =
		listOf(
			LeanbackCardItem(
				title = "title 1",
				content = "content 1",
				image = R.drawable.image1,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 2",
				content = "content 2",
				image = R.drawable.image2,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 3",
				content = "content 3",
				image = R.drawable.image3,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 4",
				content = "content 4",
				image = R.drawable.image4,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 5",
				content = "content 5",
				image = R.drawable.image5,
				badgeIcon = R.drawable.app_icon_your_company
			),
			LeanbackCardItem(
				title = "title 6",
				content = "content 6",
				image = R.drawable.image6,
				badgeIcon = R.drawable.app_icon_your_company
			)
		)
}