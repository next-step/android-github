package com.nextstep.edu.github.domain.di

import com.nextstep.edu.github.domain.GithubRepository
import com.nextstep.edu.github.domain.RepositoriesFetchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class UseCaseModule {

    @Provides
    @Singleton
    fun providesRepositoriesFetchUseCase(githubRepository: GithubRepository) =
        RepositoriesFetchUseCase(githubRepository = githubRepository)
}
