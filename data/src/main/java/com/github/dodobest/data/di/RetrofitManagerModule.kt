package com.github.dodobest.data.di

import com.github.dodobest.data.retrofit.RetrofitManagerImpl
import com.github.dodobest.domain.RetrofitManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RetrofitManagerModule {
    @Binds
    abstract fun provideRetrofitManager(retrofitManagerImpl: RetrofitManagerImpl) : RetrofitManager
}