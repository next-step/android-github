package com.example.github.data.repository.local

import com.example.github.data.mapper.githubRepoDataToGithubRepoEntity
import com.example.github.data.room.GithubRepoDao
import com.example.github.data.room.GithubRepoEntity
import com.example.githubdomain.GithubRepoData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

internal class LocalGithubDataSourceImpl(private val githubDao: GithubRepoDao): LocalGithubDataSource {
    override suspend fun getGitHubRepo(): List<GithubRepoEntity> {
        return CoroutineScope(Dispatchers.IO).async {
            githubDao.getGitHubRepo()
        }.await()
    }

    override fun insertGitHubRepo(gitHubRepoDataList: List<GithubRepoData>) {
        githubDao.insertGithubRepoEntityList(gitHubRepoDataList.githubRepoDataToGithubRepoEntity())
    }
}
