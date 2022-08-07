package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.Repository

interface GithubRepository {

    suspend fun fetchRepositoryList(): Result<List<Repository>>
}
