package camp.nextstep.edu.github.data

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 04..
 */

class GithubRepositoryTest {
    private lateinit var server: MockWebServer
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        server = MockWebServer()
        val baseUrl = server.url("")

        apiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiService::class.java)
    }

    @Test
    fun `깃헙 데이터 가져온다`() = runBlocking {
        // given
        val response = MockResponse()
            .setBody(File("src/test/java/resources/githubData.json").readText())
        server.enqueue(response)

        // when
        val actual = apiService.getGithub()

        // then
        assertEquals(actual[0].fullName, "mojombo/grit")
        assertEquals(
            actual[0].description,
            "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
        )
    }
}