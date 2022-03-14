package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.domain.GithubRepoModel

class RepoAdapter : RecyclerView.Adapter<RepoViewHolder>() {
    private val repos: MutableList<GithubRepoModel> = mutableListOf()

    fun updateRepos(repos: List<GithubRepoModel>) {
        this.repos.clear()
        this.repos.addAll(repos)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = repos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.tvAuthor.text = repos[position].fullName
        holder.tvDescription.text = repos[position].description
    }
}