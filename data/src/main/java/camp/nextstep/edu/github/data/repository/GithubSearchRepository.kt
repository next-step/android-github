package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.model.SearchResponse
import retrofit2.Response

interface GithubSearchRepository {

    suspend fun searchGitHubs(): Response<SearchResponse>

}