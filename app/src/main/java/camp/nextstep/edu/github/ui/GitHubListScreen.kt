package camp.nextstep.edu.github.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GitHubListScreen(repositories: List<Pair<String, String>>) {
    LazyColumn {
        item {
            repositories.forEach { GitHubListItem(fullName = it.first, description = it.second) }
        }
    }
}

@Composable
fun GitHubListItem(fullName: String, description: String) {
    Card(
        Modifier
            .padding(12.dp)
            .border(width = 4.dp, color = Color.Black)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column {
                Text("Repository = $fullName")
                Text("Description = $description")
            }
        }
    }
}