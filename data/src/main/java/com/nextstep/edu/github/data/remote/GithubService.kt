package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.domain.RepositoryItem
import retrofit2.Call
import retrofit2.http.GET

internal interface GithubService {

    @GET("repositories")
    suspend fun fetchRepositories(): List<RepositoryItem>
}
