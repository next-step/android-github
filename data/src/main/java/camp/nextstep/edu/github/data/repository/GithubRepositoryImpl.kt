package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.di.NetworkModule
import camp.nextstep.edu.github.data.dto.GithubRepositoryDto

internal class GithubRepositoryImpl {
    suspend fun getRepositories(): List<GithubRepositoryDto> {
        return NetworkModule.githubApi.getRepositories()
    }
}
