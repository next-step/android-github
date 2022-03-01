package camp.nextstep.edu.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
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
    }
}