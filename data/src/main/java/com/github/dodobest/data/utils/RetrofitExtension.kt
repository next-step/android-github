package com.github.dodobest.data.utils

import com.github.dodobest.domain.MyRetrofit


fun retrofit2.Retrofit.toMyRetrofit() : MyRetrofit {
    MyRetrofit(
        callFactory = callFactory,
        this.baseUrl = baseUrl,
        this.converterFactories = converterFactories, // Copy+unmodifiable at call site.
        this.callAdapterFactories = callAdapterFactories, // Copy+unmodifiable at call site.
        this.callbackExecutor = callbackExecutor,
        this.validateEagerly = validateEagerly,
    )
}