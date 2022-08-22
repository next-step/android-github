package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.GithubStorage

class GithubStorageAdapter :
    ListAdapter<GithubStorage, GithubStorageAdapter.ViewHolder>(GithubStorageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
            .let { view -> ViewHolder(view) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRepoBinding.bind(view)
        fun bind(githubStorage: GithubStorage) {
            binding.githubStorage = githubStorage
        }

    }
}

class GithubStorageDiffCallback : DiffUtil.ItemCallback<GithubStorage>() {
    override fun areItemsTheSame(
        oldItem: GithubStorage,
        newItem: GithubStorage,
    ): Boolean = oldItem.hashCode() == newItem.hashCode()


    override fun areContentsTheSame(
        oldItem: GithubStorage,
        newItem: GithubStorage,
    ): Boolean = oldItem == newItem
}