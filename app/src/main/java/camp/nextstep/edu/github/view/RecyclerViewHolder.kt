package camp.nextstep.edu.github.view

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.RepositoryVO

class RecyclerViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: RepositoryVO) {
        binding.tvFullName.text = data.fullName
        binding.tvDesc.text = data.desc
    }
}