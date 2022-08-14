package camp.nextstep.edu.github

import androidx.recyclerview.widget.DiffUtil
import camp.nextstep.edu.github.domain.GithubRepositoryData

class DiffUtilItemCallbackForGithubRepositoryData : DiffUtil.ItemCallback<GithubRepositoryData>() {
    override fun areItemsTheSame(
        oldItem: GithubRepositoryData,
        newItem: GithubRepositoryData
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GithubRepositoryData,
        newItem: GithubRepositoryData
    ): Boolean {
        return oldItem == newItem
    }
}