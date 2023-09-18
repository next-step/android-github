package com.example.github.data.repository
import com.example.github.data.mapper.githubRepoEntityToGithubRepoData
import com.example.github.data.mapper.remoteGithubDataToGithubRepoData
import com.example.github.data.repository.local.LocalGithubDataSource
import com.example.github.data.repository.remote.RemoteGithubDataSource
import com.example.githubdomain.GitHubRepository
import com.example.githubdomain.GithubRepoData
import java.net.SocketTimeoutException

internal class GithubRepositoryImpl(
    private val localGithubDataSource: LocalGithubDataSource,
    private val remoteGithubDataSource: RemoteGithubDataSource
): GitHubRepository {

    override suspend fun getGitHubRepoData(): List<GithubRepoData> {
        val localData = localGithubDataSource.getGitHubRepo()
        return if(localData.isNullOrEmpty()) {
            try {
                remoteGithubDataSource.getGitHubRepo().remoteGithubDataToGithubRepoData().also {
                    localGithubDataSource.insertGitHubRepo(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }

        } else {
            localData.githubRepoEntityToGithubRepoData()
        }
    }

    suspend fun isEmptyLocalData() = localGithubDataSource.getGitHubRepo().isNullOrEmpty()
}
