package com.example.github_data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubRepo")
data class GithubRepoEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: String,

    @ColumnInfo(name = "fullName")
    @SerializedName("full_name")
    val fullName: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String?
)
