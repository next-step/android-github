package camp.nextstep.edu.github.data.repository

import camp.nextstep.edu.github.data.retrofit.GithubRetrofit
import camp.nextstep.edu.github.domain.model.Repository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class GithubRepositoryImplTest {

    private lateinit var mockServer: MockWebServer
    private lateinit var githubRepository: GithubRepositoryImpl

    @Before
    fun setUp() {
        mockServer = MockWebServer()
        githubRepository = GithubRepositoryImpl(
            GithubRetrofit(mockServer.url("").toString()).githubService
        )
    }

    @Test
    fun `목록을 요청하면 성공적으로 목록이 반환된다`() = runTest {
        // given
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(File("src/test/resources/RepositoryList.json").readText())
        mockServer.enqueue(response)

        val sampleList = listOf(
            Repository(
                fullName = "mojombo/grit",
                description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
            ),
            Repository(
                fullName = "wycats/merb-core",
                description = null
            ),
        )

        // when
        val actual = githubRepository.fetchRepositoryList().getOrNull()

        // then
        assertThat(actual).isEqualTo(sampleList)
    }
}
