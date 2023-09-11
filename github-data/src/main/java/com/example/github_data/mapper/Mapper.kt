package com.example.github_data.mapper

import com.example.github_data.room.GithubRepoEntity
import com.example.githubdomain.GithubRepoData

fun mapperToGithubRepo(githubRepoEntityList : List<GithubRepoEntity>): List<GithubRepoData> {
    return githubRepoEntityList.toList().map {
        GithubRepoData(
            id = it.id,
            fullName = it.fullName,
            description = it.description ?: ""
        )
    }
}
