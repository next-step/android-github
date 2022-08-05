package camp.nextstep.edu.github.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.model.GithubRepoUiModel

class MainAdapter : ListAdapter<GithubRepoUiModel, MainViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<GithubRepoUiModel>() {
            override fun areItemsTheSame(
                oldItem: GithubRepoUiModel,
                newItem: GithubRepoUiModel,
            ): Boolean = oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(
                oldItem: GithubRepoUiModel,
                newItem: GithubRepoUiModel,
            ): Boolean = oldItem == newItem
        }
    }
}
