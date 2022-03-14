package camp.nextstep.edu.github

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class ResultAdapterViewHolder(binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    private val fullName: TextView = binding.fullName
    private val description: TextView = binding.description

    fun setNameAndDescription(fullName: String?, description: String?) {
        this.fullName.text = fullName
        this.description.text = description
    }
}