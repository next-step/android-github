package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.GithubRepositoryData

class RepositoryViewHolder(private val binding: ItemRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: GithubRepositoryData) {
        binding.repositoryData = data
    }
}