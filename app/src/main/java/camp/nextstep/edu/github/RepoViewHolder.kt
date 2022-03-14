package camp.nextstep.edu.github

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class RepoViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
    private val binding = ItemRepoBinding.bind(containerView)
    val tvAuthor: TextView = binding.tvAuthor
    val tvDescription: TextView = binding.tvDescription
}