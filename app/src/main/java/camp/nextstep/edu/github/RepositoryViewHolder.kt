package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.Repository

/**
 * Created by link.js on 2022. 08. 08..
 */
class RepositoryViewHolder(private val binding: ItemRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repository) {
        binding.repository = repository
    }
}