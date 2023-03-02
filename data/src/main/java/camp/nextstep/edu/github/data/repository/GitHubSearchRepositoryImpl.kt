package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.api.RetrofitInstance.api
import camp.nextstep.edu.github.data.model.SearchResponse
import retrofit2.Response

class GitHubSearchRepositoryImpl : GithubSearchRepository {
    override suspend fun searchGitHubs(): Response<SearchResponse> {
        return api.searchGithub()
    }
}