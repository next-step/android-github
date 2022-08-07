package camp.nextstep.edu.github.data

import retrofit2.Retrofit

internal object ServiceModule {

    fun provideGithubService(retrofit: Retrofit) =
        retrofit.create(GithubService::class.java)
}
