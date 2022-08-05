package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.domain.Github
import camp.nextstep.edu.github.domain.GithubRepository
import javax.inject.Inject

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 04..
 */
class DefaultGithubRepository @Inject constructor() : GithubRepository {
    private val apiService = ApiServiceFactory.apiService
    override suspend fun getGithub(): List<Github> {
        return apiService.getGithub().map { it.mapToDomain() }
    }
}