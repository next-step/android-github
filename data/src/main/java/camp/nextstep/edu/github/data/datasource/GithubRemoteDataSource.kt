package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.domain.model.GithubStorage

interface GithubRemoteDataSource {
    suspend fun getRepositories(): Result<List<GithubStorage>>
}