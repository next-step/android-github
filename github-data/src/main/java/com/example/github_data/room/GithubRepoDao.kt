package com.example.github_data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.github_domain.GithubRepoData

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
    fun getGitHubRepo(): List<GithubRepoData>
}
