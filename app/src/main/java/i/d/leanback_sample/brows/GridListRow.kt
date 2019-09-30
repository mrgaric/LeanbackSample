package i.d.leanback_sample.brows

import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ObjectAdapter

class GridListRow(
    header: HeaderItem,
    adapter: ObjectAdapter,
    val numRows: Int = 1
) : ListRow(
    header,
    adapter
)