package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.remote.service.GithubService
import camp.nextstep.edu.github.domain.entity.GithubRepo
import camp.nextstep.edu.github.domain.repository.GithubRepoRepository

/**
 * Created By Malibin
 * on 9월 09, 2021
 */

internal class RealGithubRepoRepository(
    private val githubService: GithubService,
) : GithubRepoRepository {

    override suspend fun getRepositoriesOf(userName: String): List<GithubRepo>? {
        val response = githubService.getUserRepos(userName)
        return if (response.isSuccessful) response.body()?.map { it.toGithubRepo() }
        else null
    }
}
