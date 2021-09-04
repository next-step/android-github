package com.nextstep.edu.github.data.di

import com.nextstep.edu.github.data.remote.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun providesGithubService(retrofit: Retrofit): GithubService = retrofit
        .create(GithubService::class.java)
}
