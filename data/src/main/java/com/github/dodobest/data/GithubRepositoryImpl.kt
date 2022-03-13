package com.github.dodobest.data

import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.GithubRepository
import com.github.dodobest.domain.RESPONSE_STATE
import com.github.dodobest.domain.RetrofitManager

internal class GithubRepositoryImpl(
    private val retrofitManager: RetrofitManager
) : GithubRepository {
    override fun getRepositories(completion: (RESPONSE_STATE, List<GithubData>) -> Unit) {
        retrofitManager.getRepositories(completion)
    }
}