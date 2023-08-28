package camp.nextstep.edu.github.ui.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.ui.UiStatus
import camp.nextstep.edu.github.ui.main.GithubMainState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubRepositoryPage(
    status: GithubMainState
) {
    if (status.status == UiStatus.Loading) {
        ProgressLoadingView()
    }
    if (status.status == UiStatus.Success) {
        Scaffold {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                RepositoriesView(status)
            }
        }
    }
}

@Composable
private fun ProgressLoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun RepositoriesView(
    status: GithubMainState
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(status.repositories) {
            RepositoryItemView(it)
        }
    }
}

@Composable
fun RepositoryItemView(repository: GithubRepository) {
    Column {
        Text(text = repository.fullName, style = MaterialTheme.typography.displayMedium)
        Text(text = repository.description ?: "", style = MaterialTheme.typography.bodyMedium)
        Divider(color = Color.Black)
    }
}
