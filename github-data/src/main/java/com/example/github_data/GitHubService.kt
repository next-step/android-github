package com.example.github_data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object GitHubService {
    private val BASE_URL = "https://api.github.com"

    fun getGitHubService(): GitHubApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)
    }
}
