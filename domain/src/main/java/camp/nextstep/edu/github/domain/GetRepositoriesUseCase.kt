package camp.nextstep.edu.github.domain

import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val repository: GithubRepository
) {

    suspend operator fun invoke(): Result<List<Repository>> =
        kotlin.runCatching { repository.getRepositories() }
}
