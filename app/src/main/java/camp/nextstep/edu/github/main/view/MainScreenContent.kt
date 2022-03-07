package camp.nextstep.edu.github.main.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import camp.nextstep.edu.github.main.MainViewModel
import camp.nextstep.edu.github.main.model.UiRepository

@Composable
fun MainScreenContent(mainViewModel: MainViewModel) {
    val uiRepositoryList = mainViewModel.repositoryList.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(uiRepositoryList) { item ->
            MainPageContentItem(item)
        }
    }
}

@Composable
private fun MainPageContentItem(item: UiRepository) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = item.fullName, style = MaterialTheme.typography.h6)
        Text(
            text = item.descriptions,
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.body2,
        )
    }
}
