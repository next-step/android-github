package com.example.github_data.repository.local

import com.example.github_data.room.GithubRepoDao
import com.example.github_data.room.GithubRepoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

internal class LocalGithubDataSourceImpl(private val githubDao: GithubRepoDao): LocalGithubDataSource {
    // Room에서 데이터 받아옴

    override suspend fun getGitHubRepo(): List<GithubRepoEntity> {
        return GlobalScope.async(Dispatchers.IO) {
            githubDao.getGitHubRepo()
        }.await()
    }
}
