package camp.nextstep.edu.github.binding_adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("custom:submitList")
fun <T, VH : RecyclerView.ViewHolder> submitList(recyclerView: RecyclerView, itemList: List<T>) {
    (recyclerView.adapter as? ListAdapter<T, VH>)?.submitList(itemList)
}
