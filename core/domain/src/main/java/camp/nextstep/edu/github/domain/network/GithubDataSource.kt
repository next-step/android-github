package camp.nextstep.edu.github.domain.network

import camp.nextstep.edu.github.domain.GithubRepository

interface GithubDataSource {
    suspend fun fetchRepositories(): List<GithubRepository>
}
