package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class GitHubReposAdapter : ListAdapter<GitHubRepoViewData, GitHubRepoViewHolder>(GitHubRepoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepoViewHolder {
        return GitHubRepoViewHolder(ItemRepoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    internal class GitHubRepoDiffCallback : DiffUtil.ItemCallback<GitHubRepoViewData>() {
        override fun areItemsTheSame(oldItem: GitHubRepoViewData, newItem: GitHubRepoViewData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubRepoViewData, newItem: GitHubRepoViewData): Boolean {
            return oldItem == newItem
        }
    }
}

class GitHubRepoViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(viewData: GitHubRepoViewData) {
        binding.gitHubRepoViewData = viewData
    }
}
