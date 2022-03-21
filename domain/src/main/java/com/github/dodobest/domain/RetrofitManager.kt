package com.github.dodobest.domain

interface RetrofitManager {
    fun getRepositories(onSuccess: (List<GithubData>) -> Unit, onFailure: (Throwable) -> Unit)
}