package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemGithubRepoBinding
import camp.nextstep.edu.github.domain.GithubRepo

class GithubRepoListAdapter: ListAdapter<GithubRepo, GithubRepoListAdapter.GithubRepoViewHolder>(GithubRepoDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder =
        GithubRepoViewHolder(
            ItemGithubRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class GithubRepoViewHolder(private val binding: ItemGithubRepoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GithubRepo) = with(binding) {
            binding.data = item
        }
    }

    class GithubRepoDiffUtil: DiffUtil.ItemCallback<GithubRepo>() {
        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean =
            newItem.id == oldItem.id

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean =
            newItem == oldItem
    }
}