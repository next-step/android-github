package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.model.Repository
import retrofit2.Response

internal interface GithubSearchRepository {

    suspend fun searchGitHubs(): Response<List<Repository>>

}
