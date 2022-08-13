package camp.nextstep.edu.github.view

import androidx.recyclerview.widget.DiffUtil
import camp.nextstep.edu.github.domain.RepositoryVO

class ViewDiffCallback : DiffUtil.ItemCallback<RepositoryVO>() {
    override fun areItemsTheSame(oldItem: RepositoryVO, newItem: RepositoryVO): Boolean {
        return oldItem.fullName == newItem.fullName
    }

    override fun areContentsTheSame(oldItem: RepositoryVO, newItem: RepositoryVO): Boolean {
        return oldItem == newItem
    }
}