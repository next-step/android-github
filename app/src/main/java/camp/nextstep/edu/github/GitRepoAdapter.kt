package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.data.GithubRepository
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class GitRepoAdapter : ListAdapter<GithubRepository, GitRepoViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return GitRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GithubRepository>() {
            override fun areItemsTheSame(
                old: GithubRepository,
                new: GithubRepository
            ): Boolean = old == new

            override fun areContentsTheSame(
                old: GithubRepository,
                new: GithubRepository
            ): Boolean = old == new
        }
    }
}

class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRepoBinding.bind(view)
    fun bind(item: GithubRepository) {
        binding.item = item
    }
}
