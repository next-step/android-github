package com.github.dodobest.domain

interface TaskRepository {
    fun getRepositories(): List<GithubData>
}