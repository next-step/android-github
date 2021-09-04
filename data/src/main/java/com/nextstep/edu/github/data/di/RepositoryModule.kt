package com.nextstep.edu.github.data.di

import com.nextstep.edu.github.data.GithubRepositoryImpl
import com.nextstep.edu.github.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsGithubRepository(githubRepositoryImpl: GithubRepositoryImpl): GithubRepository
}
