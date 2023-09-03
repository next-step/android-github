package com.example.github_data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "githubRepo")
data class GithubRepoEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "full_name")
    val full_name: String,

    @ColumnInfo(name = "description")
    val description: String?
)
