package com.github.dodobest.domain

interface Retrofit {
    fun getRepositories() : Call<List<GithubRepository>>
}