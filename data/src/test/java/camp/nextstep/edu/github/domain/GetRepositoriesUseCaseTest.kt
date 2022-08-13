package camp.nextstep.edu.github.domain

import camp.nextstep.edu.github.data.DefaultGitHubRepository
import camp.nextstep.edu.github.data.GithubService
import camp.nextstep.edu.github.data.di.DataModule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class GetRepositoriesUseCaseTest {
    private lateinit var useCase: GetRepositoriesUseCase
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
        useCase = GetRepositoriesUseCase(repository)
    }

    @Test
    fun `Github Repo 목록을 불러온다`() = runTest {
        //given
        val expected = "mojombo/grit"

        //when
        val actual = useCase().first().list().firstOrNull()?.fullName

        //then
        assertThat(actual).isEqualTo(expected)
    }
}