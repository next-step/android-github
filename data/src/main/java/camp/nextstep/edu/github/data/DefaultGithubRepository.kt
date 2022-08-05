package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.GithubRepository

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 04..
 */
internal class DefaultGithubRepository : GithubRepository {
    private val apiService = ApiServiceFactory.apiService
    override suspend fun getGithub(): List<GithubResponse> {
        return apiService.getGithub()
    }
}