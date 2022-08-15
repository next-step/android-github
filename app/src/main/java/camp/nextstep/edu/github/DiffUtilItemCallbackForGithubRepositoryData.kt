package camp.nextstep.edu.github

import androidx.recyclerview.widget.DiffUtil
import camp.nextstep.edu.github.domain.GithubRepositoryResponse

class DiffUtilItemCallbackForGithubRepositoryData : DiffUtil.ItemCallback<GithubRepositoryResponse>() {
    override fun areItemsTheSame(
        oldItem: GithubRepositoryResponse,
        newItem: GithubRepositoryResponse
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GithubRepositoryResponse,
        newItem: GithubRepositoryResponse
    ): Boolean {
        return oldItem == newItem
    }
}