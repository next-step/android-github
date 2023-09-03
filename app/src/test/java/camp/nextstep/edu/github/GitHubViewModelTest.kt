package camp.nextstep.edu.github

import com.example.github_data.GitHubApi
import com.example.github_data.room.GithubRepoEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File

class GitHubViewModelTest {
    val server = MockWebServer()


    private lateinit var service: GitHubApi

    @Before
    fun init() {
        val baseUrl = server.url("")

        service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create()
    }

    @Test
    fun `MockWebServer를 활용하여 getGitHubInfo() 요청을 검증한다`() = runTest(UnconfinedTestDispatcher()) {
        // given : MockResponse을 활용해 서버 응답을 세팅해둔다.
        val response = MockResponse()
            .setBody(File("src/test/resources/githubRepo.json").readText())
            .setResponseCode(200)

        server.enqueue(response)

        // when : https://api.github.com/repositories에 HTTP통신 요청을 한다.
        val actual = service.getGitHubInfo().body()

        // then : 응답 받은 값과 비교한다.
        val expected = listOf(GithubRepoEntity("1", "mojombo/grit", "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."),
            GithubRepoEntity("26", "wycats/merb-core", "Merb Core: All you need. None you don't."),
            GithubRepoEntity("27", "rubinius/rubinius", "The Rubinius Language Platform"),
            GithubRepoEntity("28", "mojombo/god", "Ruby process monitor"),)

        assertThat(actual).isEqualTo(expected)
    }
}
