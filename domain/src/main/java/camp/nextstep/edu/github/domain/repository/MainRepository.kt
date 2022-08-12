package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.model.GitHubRepos

interface MainRepository {
    suspend fun getGitHubRepositories() : GitHubRepos
}
