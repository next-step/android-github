package com.github.dodobest.data

import com.github.dodobest.data.retrofit.RetrofitManager
import com.github.dodobest.domain.GithubData
import com.github.dodobest.domain.TaskRepository

class DefaultTaskRepository(
    private val retrofitManager: RetrofitManager
) : TaskRepository{
    override fun getRepositories(): List<GithubData> {
        return retrofitManager.getRepositories()
    }
}