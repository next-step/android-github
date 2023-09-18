package com.example.github

import com.example.github.data.repository.remote.data.RemoteGithubData
import retrofit2.Response
import retrofit2.http.GET

interface GitHubApi {
    @GET("/repositories")
    suspend fun getGitHubRepo(): Response<List<RemoteGithubData>>
}
