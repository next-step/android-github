package camp.nextstep.edu.github.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import camp.nextstep.edu.github.GitHubReposAdapter
import camp.nextstep.edu.github.viewmodel.MainViewModel
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.toViewDataList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter: GitHubReposAdapter by lazy { GitHubReposAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        loadGitHubRepos()
        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun loadGitHubRepos() {
        lifecycleScope.launchWhenStarted {
            viewModel.loadGitHubRepos()
        }
    }

    private fun observeViewModel() {
        viewModel.gitHubRepos.observe(this) {
            adapter.submitList(it.toViewDataList())
        }
    }
}
