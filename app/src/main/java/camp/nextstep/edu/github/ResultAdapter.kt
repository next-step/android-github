package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import com.github.dodobest.domain.GithubData

class ResultAdapter : RecyclerView.Adapter<ResultAdapterViewHolder>() {
    private var results: List<GithubData> = emptyList()

    fun setResult(newResults: List<GithubData>) {
        results = newResults
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAdapterViewHolder {
        val binding: ItemRepoBinding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context))
        return ResultAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holderResultAdapter: ResultAdapterViewHolder, position: Int) {
        holderResultAdapter.setNameAndDescription(results[position].fullName, results[position].description)
    }

    override fun getItemCount(): Int {
        return results.size
    }
}