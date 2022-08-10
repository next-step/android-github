package camp.nextstep.edu.github.domain

import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(): GithubRepositories {
        return githubRepository.loadRepositories()
    }
}