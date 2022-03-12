package com.github.dodobest.domain

interface GithubRepository {
    fun getRepositories(completion: (RESPONSE_STATE, List<GithubData>) -> Unit)
}