package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GithubRepositoryInfo

interface GithubRepository {
    suspend fun getRepositories(): List<GithubRepositoryInfo>
}
