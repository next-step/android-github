package com.nextstep.edu.github.data.remote

import com.nextstep.edu.github.domain.entity.RepositoryItem
import retrofit2.http.GET

interface GithubService {

    @GET("repositories")
    suspend fun fetchRepositories(): List<RepositoryItem>
}
