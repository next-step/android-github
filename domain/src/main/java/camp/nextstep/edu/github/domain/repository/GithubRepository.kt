package camp.nextstep.edu.github.domain.repository

import camp.nextstep.edu.github.domain.Resource
import camp.nextstep.edu.github.domain.model.Repositories

interface GithubRepository {

    suspend fun getRepositories(): Resource<Repositories>
}