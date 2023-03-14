package camp.nextstep.edu.github


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.Repository

class RepositoriesSearchAdapter :
    ListAdapter<Repository, RepositoryViewHolder>(RepositoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = currentList[position]
        holder.bind(repository)
    }

    companion object {
        private val RepositoryDiffCallback = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
                return oldItem.fullName == newItem.fullName
            }

            override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
                return oldItem == newItem
            }

        }
    }

}


class RepositoryViewHolder(
    private val binding: ItemRepoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository) {
        binding.repository = repository
    }
}
