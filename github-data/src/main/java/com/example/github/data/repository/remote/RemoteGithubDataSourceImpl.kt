package com.example.github.data.repository.remote

import com.example.github.GitHubApi
import com.example.github.GitHubService
import com.example.github.data.repository.remote.data.RemoteGithubData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

internal class RemoteGithubDataSourceImpl(private val githubService: GitHubApi = GitHubService.getGitHubService()): RemoteGithubDataSource {

    override suspend fun getGitHubRepo(): List<RemoteGithubData> {
        return CoroutineScope(Dispatchers.IO).async {
            val response = githubService.getGitHubRepo()
            if(response.isSuccessful) {
                response.body()?: emptyList()
            } else {
                emptyList()
            }
        }.await()
    }
}
