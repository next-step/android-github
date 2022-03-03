package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.model.Github

interface GithubRepository {
    suspend fun getGithubRepositories(): List<Github>
}
