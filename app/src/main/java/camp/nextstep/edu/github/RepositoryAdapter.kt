package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData

class RepositoryAdapter(val viewModel: MainViewModel) : ListAdapter<GitHubRepositoryData, RepositoryViewHolder>(RepositoryComparator.COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = getItem(position)
        holder.bind(repository)
    }
}

class RepositoryViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): RepositoryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)
            return RepositoryViewHolder(binding)
        }
    }

    fun bind(repositoryData: GitHubRepositoryData) {
        binding.itemRepoTvFullname.text = repositoryData.fullName
        binding.itemRepoTvDescription.text = repositoryData.description
    }
}

object RepositoryComparator {
    val COMPARATOR by lazy {
        object : DiffUtil.ItemCallback<GitHubRepositoryData>() {
            override fun areItemsTheSame(oldItem: GitHubRepositoryData, newItem: GitHubRepositoryData): Boolean {
                return oldItem.fullName == oldItem.fullName
            }

            override fun areContentsTheSame(oldItem: GitHubRepositoryData, newItem: GitHubRepositoryData): Boolean {
                return oldItem == newItem
            }
        }
    }
}