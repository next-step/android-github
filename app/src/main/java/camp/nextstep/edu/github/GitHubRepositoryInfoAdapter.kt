package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemGithubRepositoryInfoBinding

class GitHubRepositoryInfoAdapter :
    ListAdapter<GitHubRepositoryInfo, GitHubRepositoryInfoViewHolder>(diff) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): GitHubRepositoryInfoViewHolder {
        val binding = ItemGithubRepositoryInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitHubRepositoryInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitHubRepositoryInfoViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<GitHubRepositoryInfo>() {
            override fun areItemsTheSame(
                oldItem: GitHubRepositoryInfo,
                newItem: GitHubRepositoryInfo,
            ) = oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(
                oldItem: GitHubRepositoryInfo,
                newItem: GitHubRepositoryInfo,
            ) = oldItem == newItem
        }
    }
}