package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.model.Repository

interface GithubSearchRepository {

    suspend fun searchGitHubs(): List<Repository>

}
