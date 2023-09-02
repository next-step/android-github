package camp.nextstep.edu.github

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import camp.nextstep.edu.github.ui.ErrorScreen
import camp.nextstep.edu.github.ui.HomeScreen
import camp.nextstep.edu.github.ui.LoadingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubActivity : AppCompatActivity() {

    private val githubViewModel: GithubViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiState = githubViewModel.uiState.collectAsStateWithLifecycle()

            when (uiState.value) {
                is UiState.Loading -> {
                    LoadingScreen(Modifier.fillMaxSize())
                }

                is UiState.Success -> {
                    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                        HomeScreen(
                            modifier = Modifier.padding(paddingValues),
                            repositories = (uiState.value as UiState.Success).repositories
                        )
                    }
                }

                is UiState.Error -> {
                    ErrorScreen(
                        modifier = Modifier.fillMaxSize(),
                        (uiState.value as UiState.Error).message
                    )
                }
            }

            LaunchedEffect(githubViewModel.uiEffect) {
                githubViewModel.uiEffect.collect { effect ->
                    when (effect) {
                        is UiEffect.ShowToast -> {
                            Toast.makeText(this@GithubActivity, effect.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
}
