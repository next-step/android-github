package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.GitHubRepositoryItem

class RepositoryListAdapter :
    ListAdapter<GitHubRepositoryItem, RepositoryListAdapter.HistoryViewHolder>(
        object : DiffUtil.ItemCallback<GitHubRepositoryItem>() {
            override fun areItemsTheSame(
                oldItem: GitHubRepositoryItem,
                newItem: GitHubRepositoryItem
            ): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: GitHubRepositoryItem,
                newItem: GitHubRepositoryItem
            ): Boolean =
                oldItem == newItem
        }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder =
        HistoryViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HistoryViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GitHubRepositoryItem) {
            binding.item = item
        }
    }
}