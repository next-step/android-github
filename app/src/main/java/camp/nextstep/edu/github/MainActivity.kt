package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val githubAdapter: GitHubRepositoryInfoAdapter = GitHubRepositoryInfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        addLifecycleScope()
        addObservers()
    }

    private fun addLifecycleScope() {
        lifecycleScope.launchWhenResumed {
            mainViewModel.getGithubRepositoryInfo()
        }
    }

    private fun initAdapter() {
        binding.rvGitHubRepositoryInfo.adapter = githubAdapter
    }

    private fun addObservers() {
        mainViewModel.githubRepositoryInfo.observe(this) {
            githubAdapter.submitList(it)
        }
    }
}