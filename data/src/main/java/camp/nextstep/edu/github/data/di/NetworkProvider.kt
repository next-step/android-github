package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.retrofit.BASE_URL
import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.data.retrofit.RetrofitNetwork

internal object NetworkProvider {
    fun provideGithubService(baseUrl: String = BASE_URL): GithubService {
        return RetrofitNetwork
            .create(baseUrl)
            .create(GithubService::class.java)
    }
}
