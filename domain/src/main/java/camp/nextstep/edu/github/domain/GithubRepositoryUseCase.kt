package camp.nextstep.edu.github.domain

import javax.inject.Inject

/**
 * Created by link.js on 2022. 08. 13..
 */
class GithubRepositoryUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend fun invoke(): Repositories = githubRepository.getRepositories()
}
