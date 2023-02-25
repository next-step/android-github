package camp.nextstep.edu.github

import retrofit2.Call
import retrofit2.http.GET

internal interface GithubService {
    @GET(URL.repositories)
    suspend fun getGitHubRepositories(): List<GitHubInfoResponse>
}