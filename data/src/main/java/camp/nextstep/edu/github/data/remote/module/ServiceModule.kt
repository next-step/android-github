package camp.nextstep.edu.github.data.remote.module

import camp.nextstep.edu.github.data.remote.service.GithubService
import retrofit2.Retrofit

internal object ServiceModule {

    fun getGithubService(retrofit: Retrofit) = retrofit.create(GithubService::class.java)
}
