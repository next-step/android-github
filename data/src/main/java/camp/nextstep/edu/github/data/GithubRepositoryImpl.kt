package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.mapper.mapping
import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.model.Github
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val githubService: GithubService,
) : GithubRepository {
    override suspend fun getGithubRepositories(): List<Github> =
        githubService.getGithubRepositories().mapping()
}
