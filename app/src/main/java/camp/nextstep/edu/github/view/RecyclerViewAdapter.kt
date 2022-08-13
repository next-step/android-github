package camp.nextstep.edu.github.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.RepositoryVO

class RecyclerViewAdapter : ListAdapter<RepositoryVO, RecyclerViewHolder>(ViewDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding: ItemRepoBinding = ItemRepoBinding.inflate(inflate, parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}