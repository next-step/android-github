package com.github.dodobest.domain

interface GithubRepository {
    fun getRepositories(onSuccess: (List<GithubData>) -> Unit, onFailure: (Throwable) -> Unit)
}