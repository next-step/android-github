package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.model.GithubStorageModel

class GithubStorageAdapter :
    ListAdapter<GithubStorageModel, GithubStorageAdapter.ViewHolder>(GithubStorageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
            .let { view -> ViewHolder(view) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRepoBinding.bind(view)
        fun bind(githubStorage: GithubStorageModel) {
            binding.githubStorage = githubStorage
        }

    }
}

class GithubStorageDiffCallback : DiffUtil.ItemCallback<GithubStorageModel>() {
    override fun areItemsTheSame(
        oldItem: GithubStorageModel,
        newItem: GithubStorageModel,
    ): Boolean = oldItem.hashCode() == newItem.hashCode()


    override fun areContentsTheSame(
        oldItem: GithubStorageModel,
        newItem: GithubStorageModel,
    ): Boolean = oldItem == newItem
}