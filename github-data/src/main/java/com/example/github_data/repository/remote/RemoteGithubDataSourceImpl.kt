package com.example.github_data.repository.remote

import com.example.github_data.GitHubApi
import com.example.github_data.GitHubService
import com.example.github_data.room.GithubRepoEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

internal class RemoteGithubDataSourceImpl(githubService: GitHubApi? = null): RemoteGithubDataSource {
    // retrofit통신으로 데이터 받아옴.
    private val gitHubService = githubService ?: GitHubService.getGitHubService()

    @OptIn(DelicateCoroutinesApi::class)
    override suspend fun getGitHubRepo(): List<GithubRepoEntity> {
        return GlobalScope.async(Dispatchers.IO) {
            val response = gitHubService.getGitHubInfo()
            if(response.isSuccessful) {
                response.body()?: emptyList()
            } else {
                emptyList()
            }
        }.await()
    }
}
