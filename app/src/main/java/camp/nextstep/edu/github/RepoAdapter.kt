package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.GithubRepoModel

class RepoAdapter : ListAdapter<GithubRepoModel, RepoViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding: ItemRepoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_repo,
            parent,
            false
        )

        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GithubRepoModel>() {
            override fun areItemsTheSame(
                oldItem: GithubRepoModel,
                newItem: GithubRepoModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GithubRepoModel,
                newItem: GithubRepoModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}