package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.domain.model.Github
import camp.nextstep.edu.github.domain.model.NetworkState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGithubRepositoriesUseCase @Inject constructor(private val githubRepository: GithubRepository) {
    operator fun invoke() = flow<NetworkState> {
        val githubRepositories: List<Github> = githubRepository.getGithubRepositories()
        throw IllegalArgumentException("aaaa")
        emit(NetworkState.Success(githubRepositories))
        return@flow
    }.catch { emit(NetworkState.Error(it)) }
}
