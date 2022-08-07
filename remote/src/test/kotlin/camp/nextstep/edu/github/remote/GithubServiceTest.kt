package camp.nextstep.edu.github.remote

import camp.nextstep.edu.github.data.DataException
import camp.nextstep.edu.github.data.GitRepoRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.io.File

internal class GithubServiceTest {

    private lateinit var server: MockWebServer
    private lateinit var service: GitRepoRepository

    @BeforeEach
    fun setup() {
        server = MockWebServer()
        server.start()
        val retrofit = createRetrofit(server.url("/"))
        service = createGitRepoRepository(retrofit)
    }

    @Test
    fun `Repository를 받아온다`() = runBlocking {
        // given
        // TODO sinseungmin 2022/08/04: 서버 구현체를 너무 많이 알고있는 코드 아님?
        val mockJsonString = getMockGetRepoJsonString()
        server.enqueue(MockResponse().setBody(mockJsonString))

        // when
        val actual = service.getGitRepos()

        // then
        assertThat(actual).hasSize(100)
    }

    @Test
    fun `Repository를 받아온는데 실패한다`(): Unit = runBlocking {
        // given
        server.enqueue(MockResponse().setHttp2ErrorCode(500))

        // when, then
        assertThrows<DataException> { service.getGitRepos() }
    }


    private fun getMockFile(): File {
        return File(javaClass.getResource("/get_repositories_200.json").toURI())
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

    private fun createGitRepoRepository(retrofit: Retrofit): RemoteGitRepoRepository {
        return RemoteGitRepoRepository(retrofit.create())
    }
