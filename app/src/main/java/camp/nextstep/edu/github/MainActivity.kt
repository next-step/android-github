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
    val githubAdapter: GitHubRepositoryInfoAdapter by lazy { GitHubRepositoryInfoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.view = this
        setContentView(binding.root)
        addObservers()
    }

    private fun addObservers() {
        mainViewModel.githubRepositoryInfoLiveData.observe(this) {
            githubAdapter.submitList(it)
        }
    }
}