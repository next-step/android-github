package com.github.dodobest.data.di

import com.github.dodobest.data.GithubRepositoryImpl
import com.github.dodobest.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class GithubRepositoryModule {
    @Binds
    abstract fun provideGithubRepository(githubRepositoryImpl: GithubRepositoryImpl) : GithubRepository
}