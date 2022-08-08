package camp.nextstep.edu.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import camp.nextstep.edu.github.ui.GitHubListScreen
import camp.nextstep.edu.github.ui.base.setThemeContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeContent {
            GitHubListScreen(
                listOf(
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                    "repositoryName" to "description text",
                )
            )
        }
    }
}