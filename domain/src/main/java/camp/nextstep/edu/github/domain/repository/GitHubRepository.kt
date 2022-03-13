package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GitHubRepositoryData

interface GitHubRepository {
    suspend fun getRepositories(): Result<List<GitHubRepositoryData>>
}