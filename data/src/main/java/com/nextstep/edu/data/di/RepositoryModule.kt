package com.nextstep.edu.data.di

import com.nextstep.edu.data.GithubService
import com.nextstep.edu.data.repository.RemoteRepositoryImpl
import com.nextstep.edu.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun provideRemoteRepository(
        remoteRepositoryImpl: RemoteRepositoryImpl
    ): RemoteRepository
}
