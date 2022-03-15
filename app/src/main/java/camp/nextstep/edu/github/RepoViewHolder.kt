package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.GithubRepoModel

class RepoViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: GithubRepoModel) {
        binding.data = item
    }
}