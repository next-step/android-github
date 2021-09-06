package camp.nextstep.edu.github

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import camp.nextstep.edu.github.vo.RepositoryItemVo

object ActivityMain {

    @Composable
    fun Layout(mainViewModel: MainViewModel) {
        MaterialTheme { Scaffold(mainViewModel = mainViewModel) }
    }

    @Composable
    private fun Scaffold(mainViewModel: MainViewModel) {
        Scaffold(
            content = { Content(mainViewModel = mainViewModel) }
        )
    }

    @Composable
    private fun Content(mainViewModel: MainViewModel) {
        val repositories = mainViewModel.repositories.observeAsState(emptyList())

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(repositories.value) { item ->
                ContentItem(item)
            }
        }
    }

    @Composable
    private fun ContentItem(item: RepositoryItemVo) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = item.fullName, style = MaterialTheme.typography.h6)
            Text(
                text = item.description,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.body2,
            )
        }
    }
}
