package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.domain.model.Repository
import kotlinx.coroutines.flow.Flow

interface GithubDataSource {

    fun getReposotories(): Flow<List<Repository>>
}