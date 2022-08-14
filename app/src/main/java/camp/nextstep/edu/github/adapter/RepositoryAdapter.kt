package camp.nextstep.edu.github.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.domain.GithubRepository

class RepositoryAdapter : ListAdapter<GithubRepository, RepositoryViewHolder>(
    object : DiffUtil.ItemCallback<GithubRepository>() {
        override fun areItemsTheSame(
            oldItem: GithubRepository,
            newItem: GithubRepository
        ) = oldItem.fullName == newItem.fullName

        override fun areContentsTheSame(
            oldItem: GithubRepository,
            newItem: GithubRepository
        ) = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoryViewHolder.create(parent)

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}