package camp.nextstep.edu.github

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import camp.nextstep.edu.github.databinding.ItemGithubRepositoryInfoBinding

class GitHubRepositoryInfoViewHolder(
    private val binding: ItemGithubRepositoryInfoBinding,
) : ViewHolder(binding.root) {

    fun bind(data: GitHubRepositoryInfo) {
        binding.data = data
    }

}
