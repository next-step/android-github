package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.ui.GitHubListScreen
import camp.nextstep.edu.github.ui.base.setThemeContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GithubRepositoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeContent {
            GitHubListScreen(
                listOf(
                    "repositoryName" to "description textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription text",
                    "repositoryName" to "description textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription text",
                    "repositoryName" to "description textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription text",
                    "repositoryName" to "description textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription text",
                    "repositoryName" to "description textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription textdescription text",
                    )
            )
        }
    }
}