package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.GithubRepoModel

class GithubViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(github: GithubRepoModel) {
        binding.github = github
        binding.executePendingBindings()
    }
}