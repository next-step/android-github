package com.example.github_data

import com.example.github_data.room.GithubRepoEntity
import retrofit2.Response
import retrofit2.http.GET

interface GitHubApi {
    @GET("/repositories")
    suspend fun getGitHubInfo(): Response<List<GithubRepoEntity>>
}
