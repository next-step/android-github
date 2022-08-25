package camp.nextstep.edu.github

import androidx.recyclerview.widget.DiffUtil

class DiffUtilItemCallbackForGithubRepositoryUiModel : DiffUtil.ItemCallback<GithubRepositoryUiModel>() {
    override fun areItemsTheSame(
        oldItem: GithubRepositoryUiModel,
        newItem: GithubRepositoryUiModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GithubRepositoryUiModel,
        newItem: GithubRepositoryUiModel
    ): Boolean {
        return oldItem == newItem
    }
}