package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository
import javax.inject.Inject

internal class NetworkRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : NetworkRepository {

    override suspend fun getGithubRepositories(): Result<List<GithubRepository>> {
        return runCatching {
            githubApi.getGithubRepositories().body()?.map { it.toDomain() } ?: throw Exception("네트워크 상태가 좋지 않습니다.")
        }
    }

}
