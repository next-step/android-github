package camp.nextstep.edu.github.ui

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.model.GithubRepoUiModel

class MainViewHolder(private val binding: ItemRepoBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(githubRepoUiModel: GithubRepoUiModel) {
        binding.tvFullName.text = githubRepoUiModel.fullName
        binding.tvDescription.text = githubRepoUiModel.description
    }
}
