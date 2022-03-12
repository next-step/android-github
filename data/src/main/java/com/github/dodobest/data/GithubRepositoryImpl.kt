package com.github.dodobest.data

import com.github.dodobest.data.retrofit.RetrofitManager
import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository

class GithubRepositoryImpl(
    private val retrofitManager: RetrofitManager
) : GithubRepository {
    override fun getRepositories(): List<GithubData> {
        return retrofitManager.getRepositories()
    }
}