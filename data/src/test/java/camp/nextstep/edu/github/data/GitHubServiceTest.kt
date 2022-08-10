package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.model.GitHubRepositoryEntity
import camp.nextstep.edu.github.data.service.GitHubService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

class GitHubServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var service: GitHubService

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }

    @Test
    fun `getRepositories 요청`() {
        // given
        val response = MockResponse()
            .setBody(File("src/test/resources/getGitHubRepositories.json").readText())
        server.enqueue(response)

        // when
        val actual = runBlocking { service.getRepositories() }

        // then
        val expected = listOf(
            GitHubRepositoryEntity(1, "Taemin Park", "DESC"),
            GitHubRepositoryEntity(2, "Taemin Parker", "DESC2")
        )
        assertThat(actual).isEqualTo(expected)
    }
}
