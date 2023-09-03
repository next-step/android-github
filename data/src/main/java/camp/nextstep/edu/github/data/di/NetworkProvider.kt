package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.retrofit.BASE_URL
import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.data.retrofit.GithubNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkProvider {

    @Provides
    @Singleton
    fun provideGithubService(): GithubService {
        return GithubNetwork().createRetrofit()
            .create(GithubService::class.java)
    }
}
