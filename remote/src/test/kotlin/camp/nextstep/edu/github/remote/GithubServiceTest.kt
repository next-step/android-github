package camp.nextstep.edu.github.remote

import camp.nextstep.edu.github.data.DataException
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.io.File

internal class GithubServiceTest {

    @Test
    fun `Repository를 받아온다`() = runBlocking {
        // given
        val server = MockWebServer()
        // TODO sinseungmin 2022/08/04: 서버 구현체를 너무 많이 알고있는 코드 아님?
        val mockJsonString = getMockGetRepoJsonString()
        server.enqueue(MockResponse().setBody(mockJsonString))
        server.start()
        val retrofit = createRetrofit(server.url("/"))
        val service = createGithubService(retrofit)

        // when
        val actual = service.getGitRepos()

        // then
        assertThat(actual).hasSize(100)
    }

    @Test
    fun `Repository를 받아온는데 실패한다`(): Unit = runBlocking {
        // given
        val server = MockWebServer()
        server.enqueue(MockResponse().setHttp2ErrorCode(500))
        server.start()
        val retrofit = createRetrofit(server.url("/"))
        val service = createGithubService(retrofit)

        // when, then
        assertThrows<DataException> { service.getGitRepos() }
    }


    private fun getMockFile(): File {
        return File(javaClass.getResource("/getRepos.json").toURI())
    }

    private fun getMockGetRepoJsonString(): String {
        return getMockFile().readText()
    }

    private fun createRetrofit(baseUrl: HttpUrl): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun createGithubService(retrofit: Retrofit): GithubService {
        return GithubService(retrofit.create())
    }
}