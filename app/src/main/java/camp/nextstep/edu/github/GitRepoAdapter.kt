package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.GitRepo

class GitRepoAdapter : ListAdapter<GitRepo, GitRepoViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return GitRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GitRepo>() {
            override fun areItemsTheSame(old: GitRepo, new: GitRepo): Boolean = old == new
            override fun areContentsTheSame(old: GitRepo, new: GitRepo): Boolean = old == new
        }
    }
}

class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRepoBinding.bind(view)
    fun bind(item: GitRepo) {
        binding.item = item
    }
}
