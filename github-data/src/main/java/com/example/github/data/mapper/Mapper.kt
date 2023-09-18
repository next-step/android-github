package com.example.github.data.mapper

import com.example.github.data.repository.remote.data.RemoteGithubData
import com.example.github.data.room.GithubRepoEntity
import com.example.githubdomain.GithubRepoData

fun  List<GithubRepoEntity>.githubRepoEntityToGithubRepoData(): List<GithubRepoData> {
    return this.toList().map {
        GithubRepoData(
            id = it.id,
            fullName = it.fullName,
            description = it.description ?: ""
        )
    }
}

fun List<RemoteGithubData>.remoteGithubDataToGithubRepoData(): List<GithubRepoData> {
    return this.toList().map {
        GithubRepoData(
            id = it.id,
            fullName = it.fullName,
            description = it.description
        )
    }
}

fun List<GithubRepoData>.githubRepoDataToGithubRepoEntity(): List<GithubRepoEntity> {
    return this.toList().map {
        GithubRepoEntity(
            id = it.id,
            fullName = it.fullName,
            description = it.description
        )
    }
}
