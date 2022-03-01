package camp.nextstep.edu.github.data.datasource

import camp.nextstep.edu.github.domain.model.Repository
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getReposotories(): Flow<List<Repository>>
}