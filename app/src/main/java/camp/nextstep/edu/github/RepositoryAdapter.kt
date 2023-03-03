package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import com.example.domain.model.RepositoryResource

class RepositoryAdapter :
    ListAdapter<RepositoryResource, RepositoryViewHolder>(RepositoryResourceDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return RepositoryViewHolder(binding = binding)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

object RepositoryResourceDiffCallback : DiffUtil.ItemCallback<RepositoryResource>() {
    override fun areItemsTheSame(
        oldItem: RepositoryResource,
        newItem: RepositoryResource
    ): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(
        oldItem: RepositoryResource,
        newItem: RepositoryResource
    ): Boolean {
        return oldItem == newItem
    }
}
