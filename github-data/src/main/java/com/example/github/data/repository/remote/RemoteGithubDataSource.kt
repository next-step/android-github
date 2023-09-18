package com.example.github.data.repository.remote

import com.example.github.data.repository.remote.data.RemoteGithubData

interface RemoteGithubDataSource {
    suspend fun getGitHubRepo(): List<RemoteGithubData>
}
