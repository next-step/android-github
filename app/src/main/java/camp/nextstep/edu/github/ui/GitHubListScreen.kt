package camp.nextstep.edu.github.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import camp.nextstep.edu.github.GithubRepositoriesUiEffect
import camp.nextstep.edu.github.GithubRepositoriesUiState
import camp.nextstep.edu.github.GithubRepositoriesViewModel

@Composable
fun GithubListScreen(viewModel: GithubRepositoriesViewModel) {
    GithubListState(viewModel.uiState)
    GithubListEffect(viewModel.uiEffect)
}

@Composable
private fun GithubListState(uiState: GithubRepositoriesUiState) {
    when (uiState) {
        is GithubRepositoriesUiState.Empty -> GitHubEmpty()
        is GithubRepositoriesUiState.LoadedGithubRepositories -> GithubList(uiState)
        is GithubRepositoriesUiState.LoadError -> GithubListLoadingError()
    }
}

@Composable
fun GithubListEffect(effect: GithubRepositoriesUiEffect) {
    when (effect) {
        is GithubRepositoriesUiEffect.Loading -> Loading()
        is GithubRepositoriesUiEffect.NotLoading -> Unit
    }
}

@Composable
fun GithubList(state: GithubRepositoriesUiState.LoadedGithubRepositories) {
    LazyColumn {
        item {
            state.repositories.list().forEach {
                GithubListItem(it.fullName, it.description)
            }
        }
    }
}

@Composable
fun GitHubEmpty() {
    Text("EMPTY")
}

@Composable
fun GithubListItem(fullName: String, description: String) {
    Card(
        Modifier
            .padding(12.dp)
            .border(width = 1.dp, color = Color.Black)
            .fillMaxWidth()
            .padding(12.dp)
            .height(100.dp)
    ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Column {
                Text("Repository = $fullName")
                Text("Description = $description")
            }
        }
    }
}

@Composable
fun GithubListLoadingError() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5))
                .width(140.dp)
                .height(100.dp),
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("LoadingError!!")
            }
        }
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(15))
                .width(100.dp)
                .height(100.dp),
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("Loading...")
            }
        }
    }
}
