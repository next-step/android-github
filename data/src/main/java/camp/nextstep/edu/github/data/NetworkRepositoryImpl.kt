package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository
import javax.inject.Inject

internal class NetworkRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : NetworkRepository {

    override suspend fun getGithubRepositories(): Result<List<GithubRepository>> {
        return runCatching {
            println("TestTest ghgigaigai")
            githubApi.getGithubRepositories().body()?.map { it.toDomain() } ?: throw Exception()
        }
    }

}
