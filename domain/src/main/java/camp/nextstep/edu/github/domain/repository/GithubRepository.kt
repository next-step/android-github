package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GithubStorage

interface GithubRepository {
    suspend fun getRepositories(): List<GithubStorage>
}