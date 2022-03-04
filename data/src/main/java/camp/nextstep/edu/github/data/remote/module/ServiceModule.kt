package camp.nextstep.edu.github.data.remote.module

import camp.nextstep.edu.github.data.remote.service.GithubService

internal object ServiceModule {

    fun getGithubService() = NetworkModule.getRetrofit().create(GithubService::class.java)
}
