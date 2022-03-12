package com.github.dodobest.domain

interface GithubRepository {
    fun getRepositories(): List<GithubData>
}