package camp.nextstep.edu.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.data.Injector
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import camp.nextstep.edu.github.utils.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel = MainViewModel(Injector.provideGithubRepoRepository())
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
