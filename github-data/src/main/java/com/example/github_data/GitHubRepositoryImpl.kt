package com.example.github_data

import com.example.github_data.room.GithubRepoDao
import com.example.github_domain.GitHubRepository
import com.example.github_domain.GithubRepoData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class GitHubRepositoryImpl(private val githubRepoDao: GithubRepoDao): GitHubRepository {
    override fun insertGitHubRepository() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = GitHubService.getGitHubService().getGitHubInfo()
            if(response.isSuccessful) {
                response.body()?.let {
                    githubRepoDao.deleteAllGithubRepo()
                    githubRepoDao.insertGithubRepoEntityList(it)
                }
            }
        }
    }

    override fun getGitHubRepoData(): List<GithubRepoData> {
        return githubRepoDao.getGitHubRepo()
    }
}
