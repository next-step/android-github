package com.example.github.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface GithubRepoDao {
    @Insert
    fun insertGithubRepoEntity(githubRepoEntity: GithubRepoEntity)

    @Transaction
    fun insertGithubRepoEntityList(githubRepoEntityList: List<GithubRepoEntity>) {
        githubRepoEntityList.forEach { insertGithubRepoEntity(it) }
    }

    @Query("DELETE FROM githubRepo")
    fun deleteAllGithubRepo()

    @Query("SELECT * FROM githubRepo")
    fun getGitHubRepo(): List<GithubRepoEntity>
}
