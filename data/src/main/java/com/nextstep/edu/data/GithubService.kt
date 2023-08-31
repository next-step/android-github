package com.nextstep.edu.data

import com.nextstep.edu.data.model.RepositoryResponse
import retrofit2.http.GET

internal interface GithubService {

    /**
     * GET : gitRepository 리스트
     **/
    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryResponse>
}
