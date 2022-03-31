package com.github.dodobest.data

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RetrofitManager
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val retrofitManager: RetrofitManager
) : GithubRepository {
    override fun getRepositories(onSuccess: (List<GithubData>) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofitManager.getRepositories(onSuccess, onFailure)
    }
}