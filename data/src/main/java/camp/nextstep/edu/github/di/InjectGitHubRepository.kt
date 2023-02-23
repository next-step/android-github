package camp.nextstep.edu.github.di

import camp.nextstep.edu.github.GitHubRepository
import camp.nextstep.edu.github.GitHubRepositoryImpl

object InjectGitHubRepository {
    fun getRepository() : GitHubRepository {
        return GitHubRepositoryImpl()
    }
}