package camp.nextstep.edu.github.ui

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.Github

class GithubViewHolder(private val binding: ItemRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Github) {
        binding.githubVo = item
        binding.executePendingBindings()
    }
}
