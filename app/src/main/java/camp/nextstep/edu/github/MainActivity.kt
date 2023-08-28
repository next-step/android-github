package camp.nextstep.edu.github

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import camp.nextstep.edu.github.theme.GitHubMainTheme
import camp.nextstep.edu.github.ui.main.component.GithubRepositoryPage
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: GithubRepositoriesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GitHubMainTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Main") {
                        addMain(navController)
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.addMain(navController: NavHostController) {
        composable(route = "Main") {
            val state by viewModel.collectAsState()
            viewModel.collectSideEffect {
            }
            GithubRepositoryPage(state)
        }
    }
}

@Composable
fun GithubMain() {
    val navController = rememberNavController()
}
