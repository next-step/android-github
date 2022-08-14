package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GithubRemoteStorage

interface GithubRepository {
    suspend fun getRepositories(): List<GithubRemoteStorage>
}