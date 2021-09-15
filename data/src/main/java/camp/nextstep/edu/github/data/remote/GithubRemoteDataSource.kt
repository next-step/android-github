package camp.nextstep.edu.github.data.remote

import camp.nextstep.edu.github.data.GithubDataSource
import camp.nextstep.edu.github.data.remote.network.GithubService
import camp.nextstep.edu.github.data.remote.response.RepoResponse

internal class GithubRemoteDataSource(
    private val service: GithubService = GithubService.instance
) : GithubDataSource {
    override suspend fun loadRepos(): List<RepoResponse> = service.loadRepos()
}
