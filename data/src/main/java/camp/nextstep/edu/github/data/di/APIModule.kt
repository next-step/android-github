package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.service.GithubAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object APIModule {

    @Singleton
    @Provides
    fun provideGithubAPI(retrofit: Retrofit): GithubAPI =
        retrofit.create(GithubAPI::class.java)
}