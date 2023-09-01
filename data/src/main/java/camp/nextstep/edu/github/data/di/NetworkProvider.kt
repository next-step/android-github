package camp.nextstep.edu.github.data.di

import camp.nextstep.edu.github.data.retrofit.BASE_URL
import camp.nextstep.edu.github.data.retrofit.GithubService
import camp.nextstep.edu.github.data.retrofit.GithubNetwork

internal object NetworkProvider {
    fun provideGithubService(baseUrl: String = BASE_URL): GithubService {
        return GithubNetwork
            .create(baseUrl)
            .create(GithubService::class.java)
    }
}
