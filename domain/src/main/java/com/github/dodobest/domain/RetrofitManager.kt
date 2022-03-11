package com.github.dodobest.domain

interface RetrofitManager {
    fun getRepositories() : List<GithubRepository>
}