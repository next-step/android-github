package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class RepositoryListAdapter(diffUtilItemCallbackForGithubRepositoryData: DiffUtilItemCallbackForGithubRepositoryUiModel = DiffUtilItemCallbackForGithubRepositoryUiModel()) :
    ListAdapter<GithubRepositoryUiModel, RepositoryViewHolder>(
        diffUtilItemCallbackForGithubRepositoryData
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}