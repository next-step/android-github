package camp.nextstep.edu.github.data

import camp.nextstep.edu.github.data.di.DataModule
import camp.nextstep.edu.github.domain.GithubRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

@ExperimentalCoroutinesApi
class DefaultGitHubRepositoryTest {

    private lateinit var repository: GithubRepository
    private lateinit var server: MockWebServer
    private lateinit var githubService: GithubService

    @Before
    fun setUp() {
        server = MockWebServer()
        githubService = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GithubService::class.java)

        repository = DefaultGitHubRepository(DataModule.provideGithubService())
    }

    @Test
    fun `서버로부터 git repo 목록들을 읽어올 수 있어야 한다`() = runTest {
        //given
        val response = MockResponse()
            .setBody(File("src/test/resources/repositories.json").readText())
            .setResponseCode(200)
        server.enqueue(response)
        val expected = "mojombo/grit"

        //when
        val actual = repository.loadRepositories().list().firstOrNull()?.fullName

        //then
        assertThat(actual).isEqualTo(expected)
    }
}