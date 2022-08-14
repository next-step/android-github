package camp.nextstep.edu.github.domain

import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    fun getGithubRepositories(): Flow<UiState<List<GithubRepository>>>

}