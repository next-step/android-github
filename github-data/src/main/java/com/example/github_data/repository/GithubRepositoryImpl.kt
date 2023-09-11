package com.example.github_data.repository
import com.example.github_data.mapper.mapperToGithubRepo
import com.example.github_data.repository.local.LocalGithubDataSource
import com.example.github_data.repository.remote.RemoteGithubDataSource
import com.example.githubdomain.GitHubRepository
import com.example.githubdomain.GithubRepoData

internal class GithubRepositoryImpl(
    private val localGithubDataSource: LocalGithubDataSource,
    private val remoteGithubDataSource: RemoteGithubDataSource
): GitHubRepository {

    override suspend fun getGitHubRepoData(): List<GithubRepoData> {
        val localData = localGithubDataSource.getGitHubRepo()
        return if(localData.isNullOrEmpty()) {
            mapperToGithubRepo(remoteGithubDataSource.getGitHubRepo())
        } else {
            mapperToGithubRepo(localData)
        }
    }
}
