package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.di.NetworkObject
import camp.nextstep.edu.github.data.dto.GitRepoDto

internal class GitRepoImpl {
    suspend fun getRepositories() : List<GitRepoDto> {
        return NetworkObject.githubApi.getRepositories()
    }
}