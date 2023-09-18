package com.example.github.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubRepo")
data class GithubRepoEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "fullName")
    val fullName: String,

    @ColumnInfo(name = "description")
    val description: String?
)
