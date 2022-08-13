package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.service.APIClient.retrofit
import camp.nextstep.edu.github.data.service.GithubService

object RetrofitInjector {
    fun providesGithubService(): GithubService = retrofit.create(GithubService::class.java)
}