package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val githubReposAdapter = GithubReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listGithubRepos.adapter = githubReposAdapter

        mainViewModel.toastMessage.observe(this) { showToast(it) }
        mainViewModel.githubRepos.observe(this) { githubReposAdapter.submitList(it) }
        mainViewModel.loadGithubRepos("malibinYun")
    }
}
