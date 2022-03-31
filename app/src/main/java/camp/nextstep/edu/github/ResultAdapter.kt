package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import com.github.dodobest.domain.GithubData
import javax.inject.Inject

class ResultAdapter @Inject constructor() : ListAdapter<GithubData, ResultAdapterViewHolder>(ResultDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAdapterViewHolder {
        val binding: ItemRepoBinding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context))
        return ResultAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holderResultAdapter: ResultAdapterViewHolder, position: Int) {
        holderResultAdapter.setNameAndDescription(getItem(position).fullName, getItem(position).description)
    }
}