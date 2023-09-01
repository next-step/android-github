package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import camp.nextstep.edu.github.ui.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubActivity : AppCompatActivity() {

    private val githubViewModel: GithubViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val repositories = githubViewModel.repositories.collectAsStateWithLifecycle()

            Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                HomeScreen(
                    modifier = Modifier.padding(paddingValues),
                    repositories = repositories.value
                )
            }
        }
    }
}
