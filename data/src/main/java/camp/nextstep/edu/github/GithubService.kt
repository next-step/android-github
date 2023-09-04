package camp.nextstep.edu.github

import retrofit2.http.GET

interface GithubService {

	@GET("repositories")
	suspend fun getRepositories(): List<GithubRepoResponse>
}