package camp.nextstep.edu.github.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.GithubRepository

class RepositoryViewHolder private constructor(
    private val binding: ItemRepoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GithubRepository) {
        binding.item = item
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup) = RepositoryViewHolder(
            ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

}