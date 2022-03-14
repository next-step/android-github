package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.exception.HttpResponseFailureException
import camp.nextstep.edu.github.data.mapper.toDomain
import camp.nextstep.edu.github.data.network.GitHubService
import camp.nextstep.edu.github.domain.error.Error
import camp.nextstep.edu.github.domain.model.GitHubRepositoryData
import camp.nextstep.edu.github.domain.repository.GitHubRepository
import retrofit2.Response
import java.net.UnknownHostException

internal class GitHubRepositoryImpl(private val gitHubService: GitHubService) : GitHubRepository {
    override suspend fun getRepositories(): Result<List<GitHubRepositoryData>> {
        val result = runCatching {
            gitHubService.getRepositories()
                .getResponse()
                .orEmpty()
                .toDomain()
        }

        return when (val exception = result.exceptionOrNull()) {
            null -> result
            is UnknownHostException -> return Result.failure(Error.NetworkUnavailable)
            is HttpResponseFailureException -> return Result.failure(Error.NetworkUnavailable)
            else -> Result.failure(exception)
        }
    }
}

internal fun <T> Response<T>.getResponse(): T? {
    if(this.isSuccessful) {
       return this.body()
    } else {
       throw HttpResponseFailureException(this.code(), this.message())
    }
}