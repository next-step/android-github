package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository

/**
 * Created By Malibin
 * on 9월 10, 2021
 */

object Injector {

    @JvmStatic
    fun provideGithubRepoRepository(): GithubRepoRepository {
        val githubService = GithubService.newInstance()
        return RealGithubRepoRepository(githubService)
    }
}
