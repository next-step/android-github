package com.github.dodobest.data

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RESPONSE_STATE
import com.github.dodobest.domain.RetrofitManager

internal class GithubRepositoryImpl(
    private val retrofitManager: RetrofitManager
) : GithubRepository {
    override fun getRepositories(onSuccess: (List<GithubData>) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofitManager.getRepositories(onSuccess, onFailure)
    }
}