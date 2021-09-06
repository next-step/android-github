package com.nextstep.edu.github.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun providesKotlinJsonAdapterFactory(): KotlinJsonAdapterFactory = KotlinJsonAdapterFactory()

    @Provides
    @Singleton
    fun providesMoshi(jsonAdapter: KotlinJsonAdapterFactory): Moshi = Moshi
        .Builder()
        .add(jsonAdapter)
        .build()

    @Provides
    @Singleton
    fun providesMoshiConverter(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(
        converterFactory: MoshiConverterFactory,
        client: OkHttpClient
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(converterFactory)
        .client(client)
        .build()

    companion object {
        private const val BASE_URL = "https://api.github.com/"
    }
}
