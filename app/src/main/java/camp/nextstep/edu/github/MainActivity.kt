package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val githubRepository = DefaultGithubRepository()
//        val getGithubRepositories = GetGithubRepositories(githubRepository)
//
//        getGithubRepositories()
//            .onEach { println(it) }
//            .catch { println(it) }
//            .launchIn(lifecycleScope)

        viewModel.getGithubRepositories()
    }
}