package camp.nextstep.edu.github

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.model.Github

class GithubAdapter : ListAdapter<Github, GithubViewHolder>(DiffCallbackUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val view = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallbackUtil : DiffUtil.ItemCallback<Github>() {
        override fun areItemsTheSame(oldItem: Github, newItem: Github): Boolean =
            oldItem.fullName == newItem.fullName

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Github,
            newItem: Github
        ): Boolean = oldItem == newItem
    }
}
