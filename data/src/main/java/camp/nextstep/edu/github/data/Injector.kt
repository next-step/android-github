package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.repository.GitHubSearchRepositoryImpl
import camp.nextstep.edu.github.domain.GithubSearchRepository

object Injector {

    fun provideGithubSearchRepository(): GithubSearchRepository {
        return GitHubSearchRepositoryImpl()
    }
}
