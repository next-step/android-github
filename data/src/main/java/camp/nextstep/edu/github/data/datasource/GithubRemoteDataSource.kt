package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.domain.model.GithubRemoteStorage

interface GithubRemoteDataSource {
    suspend fun getRepositories(): List<GithubRemoteStorage>
}