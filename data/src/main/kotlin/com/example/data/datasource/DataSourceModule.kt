package com.example.data.datasource

import com.example.data.retrofit.RetrofitModule
import com.example.data.retrofit.RetrofitNetwork
import com.example.data.retrofit.RetrofitNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    fun buildNetworkDataSource(retrofitNetworkApi: RetrofitNetworkApi): NetworkDataSource {
        return RetrofitNetwork(retrofitNetworkApi)
    }
}
