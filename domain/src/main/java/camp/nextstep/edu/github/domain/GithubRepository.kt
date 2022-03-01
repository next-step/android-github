package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.model.Repositories
import kotlinx.coroutines.flow.Flow

interface GithubRepository {

    fun getRepositories(): Flow<Repositories>
}