package camp.nextstep.edu.github.domain

import javax.inject.Inject

class GetGithubRepositoryUsecase @Inject constructor(private val githubRepository: GithubRepository) {

    suspend fun invoke(): Result<List<RepositoryVO>> = runCatching {
        githubRepository.getRepositories()
    }
}