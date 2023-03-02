package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var githubAdapter: GitHubRepositoryInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        addObservers()
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getGithubRepositoryInfo()
    }

    private fun initAdapter() {
        githubAdapter = GitHubRepositoryInfoAdapter()
        binding.rvGitHubRepositoryInfo.adapter = githubAdapter
    }

    private fun addObservers() {
        mainViewModel.githubRepositoryInfo.observe(this) {
            githubAdapter.submitList(it)
        }
    }
}