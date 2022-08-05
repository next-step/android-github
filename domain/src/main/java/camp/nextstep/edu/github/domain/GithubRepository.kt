package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.data.GithubResponse

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
interface GithubRepository {
    suspend fun getGithub(): List<GithubResponse>
}