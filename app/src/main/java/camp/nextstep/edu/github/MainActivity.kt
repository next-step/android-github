package camp.nextstep.edu.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.GitRepoAdapter.GitRepoViewHolder
import camp.nextstep.edu.github.data.GithubRepository
import camp.nextstep.edu.github.data.GithubService
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val gitRepoAdapter by lazy { GitRepoAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initList()
    }
    private fun initList() {
        with(binding.list) {
            itemAnimator = null
            adapter = gitRepoAdapter
        }
        viewModel.repos.observe(this) {
            gitRepoAdapter.submitList(it)
        }
    }
}

class GitRepoAdapter : ListAdapter<GithubRepository, GitRepoViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return GitRepoViewHolder(view)
    }
    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GithubRepository>() {
            override fun areItemsTheSame(
                old: GithubRepository,
                new: GithubRepository
            ): Boolean = old == new

            override fun areContentsTheSame(
                old: GithubRepository,
                new: GithubRepository
            ): Boolean = old == new
        }
    }
    class GitRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRepoBinding.bind(view)
        fun bind(item: GithubRepository) { binding.item = item }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubService: GithubService
) : ViewModel() {
    val repos: LiveData<List<GithubRepository>> = liveData { emit(githubService.getRepositories()) }
}