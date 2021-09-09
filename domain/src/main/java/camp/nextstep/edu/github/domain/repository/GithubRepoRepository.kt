package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.entity.GithubRepo

interface GithubRepoRepository {

    suspend fun getRepositoriesOf(userName: String): List<GithubRepo>?
}
