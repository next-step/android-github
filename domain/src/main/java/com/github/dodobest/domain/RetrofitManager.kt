package com.github.dodobest.domain

interface RetrofitManager {
    fun getRepositories(completion: (RESPONSE_STATE, List<GithubData>) -> Unit)
}