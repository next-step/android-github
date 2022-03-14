package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GithubRepoModel

interface GithubRepository {

    suspend fun getRepositories(): List<GithubRepoModel>
}