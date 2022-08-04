package camp.nextstep.edu.github.data

import retrofit2.http.GET

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 04..
 */

interface ApiService {
    @GET("/repositories")
    suspend fun getGithub(): List<GithubResponse>
}