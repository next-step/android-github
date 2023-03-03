package com.example.data.datasource

import com.example.data.retrofit.RetrofitModule
import com.example.data.retrofit.RetrofitNetwork

internal object DataSourceModule {

    fun buildNetworkDataSource(): NetworkDataSource {
        val retrofitNetworkApi = RetrofitModule.buildRetrofitNetworkApi()
        return RetrofitNetwork(retrofitNetworkApi)
    }
}
