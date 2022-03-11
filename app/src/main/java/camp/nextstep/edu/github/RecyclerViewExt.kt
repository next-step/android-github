package camp.nextstep.edu.github

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 *  itemLayoutId="@{@layout/item_sample}"
 *  itemList="@{items}"
 */
@BindingAdapter("itemList", "itemLayoutId")
fun <VM : Any> RecyclerView.bindListAdapterData(
    itemList: List<VM>?,
    layoutId: Int?
) {
    if (itemList == null || layoutId == null) return

    if (layoutManager == null) {
        layoutManager = LinearLayoutManager(context)
    }

    val simpleLisAdapter: SimpleListAdapter<VM>?

    if (adapter is SimpleListAdapter<*>) {
        simpleLisAdapter = adapter as? SimpleListAdapter<VM>
        simpleLisAdapter?.replaceAll(itemList)
        return
    }

    simpleLisAdapter = object : SimpleListAdapter<VM>(layoutRes = layoutId) {}
    adapter = simpleLisAdapter
    simpleLisAdapter.replaceAll(itemList)
}
