package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.GitHub

class GitHubAdapter : ListAdapter<GitHub, GitHubAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(github: GitHub) {
            binding.github = github
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<GitHub>() {
        override fun areItemsTheSame(oldItem: GitHub, newItem: GitHub): Boolean {
            return oldItem.fullName == newItem.fullName
        }

        override fun areContentsTheSame(oldItem: GitHub, newItem: GitHub): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
