package camp.nextstep.edu.github

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class ResultAdapterViewHolder(binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    val fullName: TextView = binding.fullName
    val description: TextView = binding.description
}