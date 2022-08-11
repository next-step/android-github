package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.ui.GithubListScreen
import camp.nextstep.edu.github.ui.base.setThemeContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GithubRepositoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setThemeContent {
            GithubListScreen(viewModel)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.onEvent(GithubRepositoriesUiEvent.LoadRepositories)
    }
}