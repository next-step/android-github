/**
 * @author Daewon on 02,September,2023
 *
 */

package camp.nextstep.edu.github.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import camp.nextstep.edu.github.domain.model.GithubRepository

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    repositories: List<GithubRepository>,
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState()
    ) {
        repositoryList(repositories)
    }
}

fun LazyListScope.repositoryList(
    repositories: List<GithubRepository>
) {
    itemsIndexed(repositories) { index, repository ->
        RepositoryItem(repository = repository,)
        if (index != repositories.lastIndex) {
            Divider()
        }
    }
}

@Composable
fun RepositoryItem(
    repository: GithubRepository
) {
   Column(
     modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
       verticalArrangement = Arrangement.spacedBy(4.dp)
   ) {
       Text(
           text = repository.fullName,
           style = MaterialTheme.typography.titleMedium,
           overflow = TextOverflow.Ellipsis
       )

       Text(
           text = repository.description.orEmpty(),
           style = MaterialTheme.typography.bodyMedium,
           overflow = TextOverflow.Ellipsis
       )
   }
}
