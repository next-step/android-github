package com.example.github.data.repository.local

import com.example.github.data.mapper.githubRepoDataToGithubRepoEntity
import com.example.github.data.room.GithubRepoEntity
import com.example.githubdomain.GithubRepoData

internal class FakeLocalGithubDataSourceImpl: LocalGithubDataSource {
    private val gitHubRepoEntityList = mutableListOf<GithubRepoEntity>()
    override suspend fun getGitHubRepo() = gitHubRepoEntityList

    override fun insertGitHubRepo(gitHubRepoDataList: List<GithubRepoData>) {
        gitHubRepoEntityList.addAll(gitHubRepoDataList.githubRepoDataToGithubRepoEntity())
    }
}
