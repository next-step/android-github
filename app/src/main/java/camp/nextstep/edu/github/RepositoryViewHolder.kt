package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import com.example.domain.model.RepositoryResource

class RepositoryViewHolder(private val binding: ItemRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: RepositoryResource) {
        binding.repository = repository
    }
}
