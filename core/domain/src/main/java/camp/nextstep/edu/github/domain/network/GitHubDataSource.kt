package camp.nextstep.edu.github.domain.network

import camp.nextstep.edu.github.domain.GithubRepository

interface GitHubDataSource {
    suspend fun fetchRepositories(): List<GithubRepository>
}