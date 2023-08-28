package camp.nextstep.edu.github.ui.main.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import camp.nextstep.edu.github.ui.main.GithubMainState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubRepositoryPage(
    status: GithubMainState
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}
