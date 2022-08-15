package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class RepositoryViewHolder(private val binding: ItemRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: GithubRepositoryUiModel) {
        binding.uiModel = data
    }
}