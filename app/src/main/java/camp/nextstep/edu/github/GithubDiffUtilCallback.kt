package camp.nextstep.edu.github

import androidx.recyclerview.widget.DiffUtil
import camp.nextstep.edu.github.domain.model.GithubRepoModel

class GithubDiffUtilCallback: DiffUtil.ItemCallback<GithubRepoModel>() {
    override fun areItemsTheSame(oldItem: GithubRepoModel, newItem: GithubRepoModel): Boolean {
        return oldItem.fullName == newItem.fullName
    }

    override fun areContentsTheSame(oldItem: GithubRepoModel, newItem: GithubRepoModel): Boolean {
        return oldItem == newItem
    }
}