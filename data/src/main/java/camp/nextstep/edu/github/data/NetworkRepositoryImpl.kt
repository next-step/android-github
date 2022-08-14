package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository
import camp.nextstep.edu.github.domain.NetworkRepository
import camp.nextstep.edu.github.domain.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class NetworkRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : NetworkRepository {

    override fun getGithubRepositories(): Flow<UiState<List<GithubRepository>>> {
        return flow {
            emit(UiState.Loading)

            val response = githubApi.getGithubRepositories()

            if (response.isSuccessful) {
                emit(UiState.Success(response.body()?.map { it.toDomain() }))
            } else {
                emit(UiState.Error(Exception("code : ${response.code()}")))
            }
        }.catch { emit(UiState.Error(it)) }
    }

}