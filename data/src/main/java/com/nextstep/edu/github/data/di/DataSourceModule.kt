package com.nextstep.edu.github.data.di

import com.nextstep.edu.github.data.remote.GithubRemoteDataSource
import com.nextstep.edu.github.data.remote.GithubRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindsGithubRemoteDataSource(
        githubRemoteDataSourceImpl: GithubRemoteDataSourceImpl
    ): GithubRemoteDataSource
}
